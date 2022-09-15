package com.productManagement.service;

import com.productManagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(int id);

    List<Product> findByName(String name);
}
