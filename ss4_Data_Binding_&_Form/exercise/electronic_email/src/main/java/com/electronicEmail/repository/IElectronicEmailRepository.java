package com.electronicEmail.repository;

import com.electronicEmail.model.ElectronicEmail;

import java.util.List;

public interface IElectronicEmailRepository {
    List<ElectronicEmail> showList();

    ElectronicEmail findById(int id);

    void update(ElectronicEmail electronicEmail);
}
