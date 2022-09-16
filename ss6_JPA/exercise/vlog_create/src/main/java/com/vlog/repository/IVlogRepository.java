package com.vlog.repository;

import com.vlog.model.Vlog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVlogRepository extends JpaRepository<Vlog, Integer> {

    Vlog findById(int id);

    List<Vlog> findByTitleContaining(String title);
}
