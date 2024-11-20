package com.shoppingApp.product_service.mapper;

import com.shoppingApp.product_service.dto.ProductDto;
import com.shoppingApp.product_service.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductAttributeMapper.class})
public interface ProductMapper {
    Product toEntity(ProductDto dto);
    ProductDto toDto(Product entity);
}
