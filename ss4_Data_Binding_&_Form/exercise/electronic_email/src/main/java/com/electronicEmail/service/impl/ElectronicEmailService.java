package com.electronicEmail.service.impl;

import com.electronicEmail.model.ElectronicEmail;
import com.electronicEmail.repository.IElectronicEmailRepository;
import com.electronicEmail.service.IElectronicEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicEmailService implements IElectronicEmailService {

    @Autowired
    private IElectronicEmailRepository iElectronicEmailRepository;

    @Override
    public List<ElectronicEmail> showList() {
        return iElectronicEmailRepository.showList();
    }

    @Override
    public ElectronicEmail findById(int id) {
        return iElectronicEmailRepository.findById(id);
    }

    @Override
    public void update(ElectronicEmail electronicEmail) {
        iElectronicEmailRepository.update(electronicEmail);
    }
}
