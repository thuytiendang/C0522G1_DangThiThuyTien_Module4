package com.vlog.service;

import com.vlog.model.Vlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVlogService {

    Page<Vlog> findAll(Pageable pageable);

    void save(Vlog vlog);

    Vlog findById(int id);

    void update(Vlog vlog);

    void delete(int id);

    Page<Vlog> findByTitleContaining(String title, Pageable pageable);
}
