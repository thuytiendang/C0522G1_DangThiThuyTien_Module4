package com.casestudy.service.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> showCustomerList(Pageable pageable);

    void addNewCustomer(Customer customer);

    void deleteCustomer(int id);

    void updateCustomer(Customer customer);

    Customer findById(int id);

    Page<Customer> search(String title, String address, String phone, Pageable pageable);
}
