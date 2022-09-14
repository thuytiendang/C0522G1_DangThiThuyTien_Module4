package com.productManagement.repository.impl;

import com.productManagement.model.Product;
import com.productManagement.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "PS", 32000, "Cho hoi tho thom mat", "PS"));
        products.put(2, new Product(2, "Oishi", 5000, "ngon dam vi", "Bimm"));
        products.put(3, new Product(3, "ASUS", 18000000, "Good for you!", "Asus"));
        products.put(4, new Product(4, "DELL", 20000000, "Best choice!", "Dell"));
        products.put(5, new Product(5, "Aquafina", 10000, "fresh water", "Aqua"));
        products.put(6, new Product(6, "pencil", 7000, "for baby", "Pen"));
        products.put(7, new Product(7, "Probi", 32000, "good for your health", "Probi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> product: products.entrySet()){
            if (product.getValue().getName().contains(name)){
                productList.add(product.getValue());
            }
        }
        return productList;
    }
}
