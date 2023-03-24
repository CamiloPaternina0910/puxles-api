package com.puxles.product_manager.mappers;

import com.puxles.product_manager.dtos.ProductDto;
import com.puxles.product_manager.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class ProductMapperImp implements ProductMapper{

    // Optional use MapperStruct
    @Override
    public Product toEntity(ProductDto dto) {
        if (dto == null) return null;

        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        return product;
    }

    @Override
    public ProductDto toDto(Product entity) {
        if (entity == null) return null;

        ProductDto dto = new ProductDto();
        dto.setProductId(entity.getProductId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setStock(entity.getStock());

        return dto;
    }

    @Override
    public Page<ProductDto> toDto(Page<Product> entities) {
        return entities.map(new Function<Product, ProductDto>() {
            @Override
            public ProductDto apply(Product product) {
                return toDto(product);
            }
        });
    }

    @Override
    public List<ProductDto> toDto(List<Product> products) {
        return products.stream().map(new Function<Product, ProductDto>() {
            @Override
            public ProductDto apply(Product product) {
                return toDto(product);
            }
        }).toList();
    }
}
