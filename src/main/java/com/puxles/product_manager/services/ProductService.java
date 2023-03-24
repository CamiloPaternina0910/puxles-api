package com.puxles.product_manager.services;

import com.puxles.product_manager.entities.Product;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Page<Product> findAll(int page, int elements);
    List<Product> findByName(String name);
    Page<Product> findByPrice(BigDecimal price1, BigDecimal price2, int page, int elements);
    Product findById(Long id);
    void save(Product product);
    void remove(Product product);
}
