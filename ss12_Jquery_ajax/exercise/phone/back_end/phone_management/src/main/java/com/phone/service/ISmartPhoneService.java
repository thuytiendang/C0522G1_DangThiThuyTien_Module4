package com.phone.service;

import com.phone.model.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {

    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);

    void update(SmartPhone smartPhone);
}
