package com.shoppingApp.product_service.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAttributeDto {
    private String name;
    private String value;
}
