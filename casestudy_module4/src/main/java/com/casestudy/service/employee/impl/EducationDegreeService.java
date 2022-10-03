package com.casestudy.service.employee.impl;

import com.casestudy.model.employee.EducationDegree;
import com.casestudy.repository.employee.IEducationDegreeRepository;
import com.casestudy.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> showListEducationDegree() {
        return iEducationDegreeRepository.findAll();
    }
}
