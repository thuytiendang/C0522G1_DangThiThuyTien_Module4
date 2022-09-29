package com.vlog.repository;

import com.vlog.dto.IVlogDto;
import com.vlog.model.Vlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVlogRepository extends JpaRepository<Vlog, Integer> {

//    @Query(value = "select v.title, c.name, v.id from vlog as v join category as c on v.category_id = c.id", nativeQuery = true,
//            countQuery = "select count(*) from (select v.title, c.name, v.id from vlog as v join category as c on v.category_id = c.id) temp_table")
//    Page<IVlogDto> showVlogList(Pageable pageable);
//
//    @Query(value = "select v.title, c.name, v.id from vlog as v join category as c on v.category_id = c.id where title like %:titleSearch%",nativeQuery = true,
//            countQuery = "select count(*) from (select v.title, c.name, v.id from vlog as v join category as c on v.category_id = c.id where title like %:titleSearch%) temp_table")
//    Page<IVlogDto> findByTitle(@Param("titleSearch") String title, Pageable pageable);

    @Query(value = "select * from vlog where category_id = :id",nativeQuery = true)
    List<Vlog> showListOfCategory(@Param("id") int id);

    List<Vlog> findByTitleContaining(String title);
}
