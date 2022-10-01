package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where is_delete = 0;", nativeQuery = true,
            countQuery = "select count(*) from (select * from customer where is_delete = 0) temp_table")
    Page<Customer> showCustomerList(Pageable pageable);

    @Query(value = "select * from customer where customer_name like %:nameSearch% and customer_address like %:addressSearch%" +
            " and customer_phone like %:phoneSearch% and is_delete = 0;", nativeQuery = true,
            countQuery = "select count(*) from (select * from customer where customer_name like %:nameSearch% and customer_address like %:addressSearch%\" +\n" +
                    "            \" and customer_phone like %:phoneSearch% and is_delete = 0) temp_table")
    Page<Customer> search(@Param("nameSearch") String name, @Param("addressSearch") String address, @Param("phoneSearch") String phone, Pageable pageable);
}
