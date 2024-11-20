package com.shoppingApp.inventory_service.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryDto {
    private Long productId;
    private int inventoryTotal;
    private int inventoryAvailable;
    private int inventoryReserved;
}
