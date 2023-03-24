package com.puxles.product_manager.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {

    private Long productId;

    @NotEmpty(message = "Product name is required")
    private String name;

    @NotNull(message = "Product price is required")
    private BigDecimal price;

    @NotNull(message = "Product stock is required")
    private int stock;

}
