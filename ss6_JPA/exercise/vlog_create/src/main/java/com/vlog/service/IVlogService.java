package com.vlog.service;

import com.vlog.model.Vlog;

import java.util.List;

public interface IVlogService {

    List<Vlog> findAll();

    void save(Vlog vlog);

    Vlog findById(int id);

    void update(Vlog vlog);

    void delete(int id);

    List<Vlog> findByTitleContaining(String title);;
}
