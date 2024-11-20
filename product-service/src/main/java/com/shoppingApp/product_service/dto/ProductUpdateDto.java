package com.shoppingApp.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductUpdateDto {
    private BigDecimal price;
    private Integer inventoryAvailable;
    private Integer inventoryReserved;
}
