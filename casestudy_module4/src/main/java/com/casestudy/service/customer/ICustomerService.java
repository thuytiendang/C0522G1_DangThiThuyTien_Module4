package com.casestudy.service.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> showCustomerList(Pageable pageable);

    void addNewCustomer(Customer customer);

    void deleteLogical(Integer id);

    void updateCustomer(Customer customer);

    Customer findById(int id);

    //    Page<Customer> findByCustomerNameContainingAndCustomerAddressContainingAndCustomerPhoneContaining(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);
    Page<Customer> search(Pageable pageable, String nameSearch, String addressSearch, String phoneSearch);

}
