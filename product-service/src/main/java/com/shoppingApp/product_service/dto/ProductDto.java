package com.shoppingApp.product_service.dto;


import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int inventoryTotal;
    private int inventoryAvailable;
    private int inventoryReserved;
    private Long categoryId;
    private List<ProductAttributeDto> attributes;
}

