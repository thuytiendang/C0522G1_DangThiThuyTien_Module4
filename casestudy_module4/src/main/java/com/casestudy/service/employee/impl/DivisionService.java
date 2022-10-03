package com.casestudy.service.employee.impl;

import com.casestudy.model.employee.Division;
import com.casestudy.repository.employee.IDivisionRepository;
import com.casestudy.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> showListDivision() {
        return iDivisionRepository.findAll();
    }
}
