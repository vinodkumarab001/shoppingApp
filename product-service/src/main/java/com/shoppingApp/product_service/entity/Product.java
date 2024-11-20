package com.shoppingApp.product_service.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int inventoryTotal;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int inventoryAvailable;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int inventoryReserved;

    @Column(nullable = false)
    private Long categoryId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductAttribute> attributes;
}

