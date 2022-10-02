package com.casestudy.service.customer.impl;

import com.casestudy.model.customer.Customer;
import com.casestudy.repository.customer.ICustomerRepository;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> showCustomerList(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void deleteLogical(Integer id){
        iCustomerRepository.deleteLogical(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> search(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
        return iCustomerRepository.search(nameSearch, addressSearch, phoneSearch, pageable);
    }

//    @Override
//    public Page<Customer> findByCustomerNameContainingAndCustomerAddressContainingAndCustomerPhoneContaining(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
//        return iCustomerRepository.findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerPhoneContaining(nameSearch, addressSearch, phoneSearch, pageable);
//    }


}
