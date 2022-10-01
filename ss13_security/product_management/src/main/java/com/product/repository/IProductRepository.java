package com.product.repository;

import com.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);

    List<Product> findByNameContaining(String name);
}
