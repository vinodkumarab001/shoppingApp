package com.shoppingApp.product_service.service;

import com.shoppingApp.product_service.dto.ProductDto;
import com.shoppingApp.product_service.dto.ProductUpdateDto;
import com.shoppingApp.product_service.entity.Product;
import com.shoppingApp.product_service.entity.ProductAttribute;
import com.shoppingApp.product_service.mapper.ProductMapper;
import com.shoppingApp.product_service.respository.ProductAttributeRepository;
import com.shoppingApp.product_service.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductAttributeRepository productAttributeRepository;
    @Autowired
    private final ProductMapper productMapper;

    // Get products by category
    public List<ProductDto> getProductsByCategory(Long categoryId) {
        List<Product> products = productRepository.findByCategoryIdAndInventoryAvailableGreaterThan(categoryId, 0);
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    // Add a new product
    public ProductDto addProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);

        // Save attributes
        List<ProductAttribute> attributes = productDto.getAttributes().stream()
                .map(attrDto -> {
                    ProductAttribute attribute = new ProductAttribute();
                    attribute.setName(attrDto.getName());
                    attribute.setValue(attrDto.getValue());
                    attribute.setProduct(savedProduct);
                    return attribute;
                }).collect(Collectors.toList());
        productAttributeRepository.saveAll(attributes);

        return productMapper.toDto(savedProduct);
    }




    public ProductDto updateProduct(Long productId, ProductUpdateDto updateDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (updateDto.getPrice() != null) product.setPrice(updateDto.getPrice());
        if (updateDto.getInventoryAvailable() != null) product.setInventoryAvailable(updateDto.getInventoryAvailable());
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(productId);
    }

    public ProductDto getProductDetails(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toDto(product);
    }
}
