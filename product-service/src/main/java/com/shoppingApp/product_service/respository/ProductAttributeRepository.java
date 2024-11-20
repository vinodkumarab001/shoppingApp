package com.shoppingApp.product_service.respository;


import com.shoppingApp.product_service.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
    List<ProductAttribute> findByProductId(Long productId);
}


