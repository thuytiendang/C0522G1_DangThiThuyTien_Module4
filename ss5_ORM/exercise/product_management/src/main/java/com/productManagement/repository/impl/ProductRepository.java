package com.productManagement.repository.impl;

import com.productManagement.model.Product;
import com.productManagement.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Product.class, id));
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productSearch = new ArrayList<>();
        List<Product> productList = findAll();

        for (Product item : productList) {
            if (item.getName().contains(name)) {
                productSearch.add(item);
            }
        }

        return productSearch;
    }
}
