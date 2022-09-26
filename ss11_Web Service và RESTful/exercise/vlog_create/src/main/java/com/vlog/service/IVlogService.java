package com.vlog.service;

import com.vlog.dto.IVlogDto;
import com.vlog.model.Vlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVlogService {

    //    Page<Vlog> findAll(Pageable pageable);
    List<Vlog> showListOfCategory( int id);


    List<Vlog> showVlogList();

    void save(Vlog vlog);

    Vlog findById(int id);

    void update(Vlog vlog);

    void delete(int id);

//    Page<Vlog> findByTitleContaining(String title, Pageable pageable);
}
