package com.shoppingApp.inventory_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int inventoryTotal;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int inventoryAvailable;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int inventoryReserved;
}
