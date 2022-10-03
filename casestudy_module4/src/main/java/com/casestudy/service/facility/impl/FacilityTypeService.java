package com.casestudy.service.facility.impl;

import com.casestudy.model.facility.FacilityType;
import com.casestudy.repository.facility.IFacilityTypeRepository;
import com.casestudy.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;

    @Override
    public List<FacilityType> showListFacilityType() {
        return iFacilityTypeRepository.findAll();
    }
}
