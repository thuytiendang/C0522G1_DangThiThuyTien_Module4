package com.casestudy.service.customer.impl;

import com.casestudy.model.customer.Customer;
import com.casestudy.repository.customer.ICustomerRepository;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> showCustomerList() {
        return iCustomerRepository.findAll();
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
    public Page<Customer> search(Pageable pageable, String nameSearch, String addressSearch, String phoneSearch) {
        return iCustomerRepository.search(pageable, nameSearch, addressSearch, phoneSearch);
    }

//    @Override
//    public Page<Customer> findByCustomerNameContainingAndCustomerAddressContainingAndCustomerPhoneContaining(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
//        return iCustomerRepository.findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerPhoneContaining(nameSearch, addressSearch, phoneSearch, pageable);
//    }


}
