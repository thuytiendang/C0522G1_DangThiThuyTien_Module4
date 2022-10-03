package com.casestudy.service.facility.impl;

import com.casestudy.model.facility.RentType;
import com.casestudy.repository.facility.IRentTypeRepository;
import com.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> showListRentType() {
        return iRentTypeRepository.findAll();
    }
}
