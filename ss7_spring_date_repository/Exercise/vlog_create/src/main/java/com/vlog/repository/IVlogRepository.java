package com.vlog.repository;

import com.vlog.model.Vlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVlogRepository extends JpaRepository<Vlog, Integer> {

    Vlog findById(int id);

    Page<Vlog> findByTitleContaining(String title, Pageable pageable);
}
