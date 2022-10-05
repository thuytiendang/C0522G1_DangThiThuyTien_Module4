package com.casestudy.service.facility;

import com.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {

    List<Facility> showListFacility();

    void addNewFacility(Facility facility);

    void deleteLogical(Integer id);

    void updateFacility(Facility facility);

    Facility findById(int id);

    Page<Facility> search(Pageable pageable, String facilityName);
}
