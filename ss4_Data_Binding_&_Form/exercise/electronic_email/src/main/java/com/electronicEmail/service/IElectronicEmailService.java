package com.electronicEmail.service;

import com.electronicEmail.model.ElectronicEmail;

import java.util.List;

public interface IElectronicEmailService {
    List<ElectronicEmail> showList();

    ElectronicEmail findById(int id);

    void update(ElectronicEmail electronicEmail);
}
