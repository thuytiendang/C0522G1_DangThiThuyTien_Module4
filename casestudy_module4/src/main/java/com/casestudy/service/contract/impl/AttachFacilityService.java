package com.casestudy.service.contract.impl;

import com.casestudy.model.contract.AttachFacility;
import com.casestudy.repository.contract.IAttachFacilityRepository;
import com.casestudy.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }
}
