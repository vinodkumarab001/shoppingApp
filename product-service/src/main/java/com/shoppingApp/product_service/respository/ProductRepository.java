package com.shoppingApp.product_service.respository;


import com.shoppingApp.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
    List<Product> findByCategoryIdAndInventoryAvailableGreaterThan(Long categoryId, int inventory);
}


