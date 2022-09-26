package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

//"select * from customer where customer_name like ? and customer_address like ?" +
//        " and customer_phone like ? and is_delete = 0;"

//    Page<Customer>
}
