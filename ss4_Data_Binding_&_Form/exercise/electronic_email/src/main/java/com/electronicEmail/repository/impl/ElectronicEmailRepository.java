package com.electronicEmail.repository.impl;

import com.electronicEmail.model.ElectronicEmail;
import com.electronicEmail.repository.IElectronicEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ElectronicEmailRepository implements IElectronicEmailRepository {

    private static List<ElectronicEmail> electronicEmails = new ArrayList<>();

    static {
        electronicEmails.add(new ElectronicEmail(1, "English", 25, true, "mooonDang"));
        electronicEmails.add(new ElectronicEmail(2, "Japanese", 5, false, "john"));
        electronicEmails.add(new ElectronicEmail(3, "Vietnamese", 50, false, "Alex"));
        electronicEmails.add(new ElectronicEmail(4, "Chinese", 100, true, "yumi"));
        electronicEmails.add(new ElectronicEmail(5, "Japanese", 10, false, "Sakura"));
        electronicEmails.add(new ElectronicEmail(6, "Vietnamese", 15, true, "lylyTran"));
    }

    @Override
    public List<ElectronicEmail> showList() {
        return electronicEmails;
    }

    @Override
    public ElectronicEmail findById(int id) {
        for (ElectronicEmail elect : electronicEmails){
            if (elect.getId() == id){
                return elect;
            }
        }
        return null;
    }

    @Override
    public void update(ElectronicEmail electronicEmail) {
        for (int i = 0; i < electronicEmails.size(); i++) {
            if (electronicEmails.get(i).getId() == electronicEmail.getId()) {
                electronicEmails.set(i, electronicEmail);
            }
        }
    }
}
