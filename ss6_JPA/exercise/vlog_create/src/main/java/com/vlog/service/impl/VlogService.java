package com.vlog.service.impl;

import com.vlog.model.Vlog;
import com.vlog.repository.IVlogRepository;
import com.vlog.service.IVlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VlogService implements IVlogService {

    @Autowired
    private IVlogRepository iVlogRepository;

    @Override
    public List<Vlog> findAll() {
        return iVlogRepository.findAll();
    }

    @Override
    @Modifying
    public void save(Vlog vlog) {
        iVlogRepository.save(vlog);
    }

    @Override
    public Vlog findById(int id) {
        return iVlogRepository.findById(id);
    }


    @Override
    @Modifying
    public void update(Vlog vlog) {
        iVlogRepository.save(vlog);
    }

    @Override
    public void delete(int id) {
        iVlogRepository.deleteById(id);
    }

    @Override
    public List<Vlog> findByTitleContaining(String title) {
        return iVlogRepository.findByTitleContaining(title);
    }
}
