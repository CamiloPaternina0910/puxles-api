package com.puxles.product_manager.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PricesDto {

    @NotNull(message = "Price one is required")
    private BigDecimal price1;

    @NotNull(message = "Price two is required")
    private BigDecimal price2;
}
