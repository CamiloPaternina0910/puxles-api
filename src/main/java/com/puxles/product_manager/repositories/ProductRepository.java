package com.puxles.product_manager.repositories;

import com.puxles.product_manager.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameLike(String name);
    Page<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2, Pageable pageable);
}
