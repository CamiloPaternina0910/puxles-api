package com.puxles.product_manager.mappers;

import com.puxles.product_manager.dtos.ProductDto;
import com.puxles.product_manager.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductMapper {
    Product toEntity(ProductDto dto);
    ProductDto toDto(Product entity);
    Page<ProductDto> toDto(Page<Product> entities);
    List<ProductDto> toDto(List<Product> products);
}
