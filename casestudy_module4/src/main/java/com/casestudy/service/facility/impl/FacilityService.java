package com.casestudy.service.facility.impl;

import com.casestudy.model.facility.Facility;
import com.casestudy.repository.facility.IFacilityRepository;
import com.casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public List<Facility> showListFacility() {
        return iFacilityRepository.findAll();
    }

    @Override
    public void addNewFacility(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void deleteLogical(Integer id) {
        iFacilityRepository.deleteLogical(id);
    }

    @Override
    public void updateFacility(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(int id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Facility> search(Pageable pageable, String facilityName) {
        return iFacilityRepository.search(pageable, facilityName);
    }
}
