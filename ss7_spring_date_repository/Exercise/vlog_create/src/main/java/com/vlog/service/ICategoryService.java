package com.vlog.service;

import com.vlog.model.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void update(Category category);

    void delete(int id);
}
