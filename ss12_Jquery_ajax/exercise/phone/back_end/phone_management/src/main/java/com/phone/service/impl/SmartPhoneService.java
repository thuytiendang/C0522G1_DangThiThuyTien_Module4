package com.phone.service.impl;

import com.phone.model.SmartPhone;
import com.phone.repository.ISmartphoneRepository;
import com.phone.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService {

    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;


    @Override
    public Iterable<SmartPhone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return iSmartphoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return iSmartphoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        iSmartphoneRepository.deleteById(id);
    }

    @Override
    public void update(SmartPhone smartPhone) {
        iSmartphoneRepository.save(smartPhone);
    }
}
