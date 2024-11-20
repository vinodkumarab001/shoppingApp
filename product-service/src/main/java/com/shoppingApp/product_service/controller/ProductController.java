package com.shoppingApp.product_service.controller;

import com.shoppingApp.product_service.dto.ProductDto;
import com.shoppingApp.product_service.dto.ProductUpdateDto;
import com.shoppingApp.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
     private final ProductService productService;


    // Customer: Get products by category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(
            @PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
    }

    // Admin: Add a product
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    // Admin: Update a product
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductUpdateDto updateDto) {
        return ResponseEntity.ok(productService.updateProduct(productId, updateDto));
    }

    // Admin: Delete a product
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    // Admin: Get product details
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductDetails(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductDetails(productId));
    }

}
