package com.vlog.service.impl;

import com.vlog.dto.IVlogDto;
import com.vlog.model.Vlog;
import com.vlog.repository.IVlogRepository;
import com.vlog.service.IVlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VlogService implements IVlogService {

    @Autowired
    private IVlogRepository iVlogRepository;


//    @Override
//    public Page<Vlog> findAll(Pageable pageable) {
//        return iVlogRepository.findAll(pageable);
//    }


    @Override
    public List<Vlog> showListOfCategory(int id) {
        return iVlogRepository.showListOfCategory(id);
    }

    @Override
    public List<Vlog> showVlogList() {
        return iVlogRepository.findAll();
    }

    @Override
    @Modifying
    public void save(Vlog vlog) {
        iVlogRepository.save(vlog);
    }

    @Override
    public Vlog findById(int id) {
        return iVlogRepository.findById(id).orElse(null);
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

//    @Override
//    public Page<Vlog> findByTitleContaining(String title, Pageable pageable) {
//        return null;
//    }

//    @Override
//    public Page<Vlog> findByTitleContaining(String title, Pageable pageable) {
//        return iVlogRepository.findByTitleContaining(title, pageable);
//    }
}
