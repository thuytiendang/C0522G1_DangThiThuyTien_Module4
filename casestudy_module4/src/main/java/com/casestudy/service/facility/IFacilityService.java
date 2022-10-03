package com.casestudy.service.facility;

import com.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {

    Page<Facility> showListFacility(Pageable pageable);

    void addNewFacility(Facility facility);

    void deleteLogical(Integer id);

    void updateFacility(Facility facility);

    Facility findById(int id);

    Page<Facility> search(Pageable pageable, String facilityName);
}
