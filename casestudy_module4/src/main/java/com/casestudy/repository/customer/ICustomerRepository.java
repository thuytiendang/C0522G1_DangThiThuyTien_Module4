package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where (customer_name like %:nameSearch% and customer_address like %:addressSearch%" +
            " and customer_phone like %:phoneSearch% ) and is_delete = 0 ", nativeQuery = true,
            countQuery = "select count(*) from (select * from customer where (customer_name like %:nameSearch% and customer_address like %:addressSearch% " +
                    "             and customer_phone like %:phoneSearch%) and is_delete = 0) temp_table")
    Page<Customer> search(Pageable pageable, @Param("nameSearch") String nameSearch,
                          @Param("addressSearch") String addressSearch,
                          @Param("phoneSearch") String phoneSearch);

    @Modifying
    @Transactional
    @Query(value = "update customer set is_delete = 1 where customer_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);

}
