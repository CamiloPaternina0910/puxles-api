package com.puxles.product_manager.services;

import com.puxles.product_manager.entities.Product;
import com.puxles.product_manager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(int page, int elements) {
        Pageable pageable= PageRequest.of(page-1, elements);
        return productRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findByName(String name ) {
        return productRepository.findByNameLike(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findByPrice(BigDecimal price1, BigDecimal price2, int page, int elements) {
        Pageable pageable= PageRequest.of(page-1, elements);
        return productRepository.findByPriceBetween(price1,price2,pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void remove(Product product) {
        productRepository.delete(product);
    }

}
