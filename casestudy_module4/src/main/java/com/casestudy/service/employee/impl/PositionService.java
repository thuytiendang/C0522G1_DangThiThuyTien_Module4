package com.casestudy.service.employee.impl;

import com.casestudy.model.employee.Position;
import com.casestudy.repository.employee.IPositionRepository;
import com.casestudy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> showListPosition() {
        return iPositionRepository.findAll();
    }
}
