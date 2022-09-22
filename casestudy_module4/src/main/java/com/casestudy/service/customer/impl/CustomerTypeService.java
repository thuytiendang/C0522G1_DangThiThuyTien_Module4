package com.casestudy.service.customer.impl;

import com.casestudy.model.customer.CustomerType;
import com.casestudy.repository.customer.ICustomerTypeRepository;
import com.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> showListTypeCustomer() {
        return iCustomerTypeRepository.findAll();
    }
}
