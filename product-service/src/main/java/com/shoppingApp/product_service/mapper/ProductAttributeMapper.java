package com.shoppingApp.product_service.mapper;

import com.shoppingApp.product_service.dto.ProductAttributeDto;
import com.shoppingApp.product_service.entity.ProductAttribute;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductAttributeMapper {
    ProductAttribute toEntity(ProductAttributeDto dto);
    ProductAttributeDto toDto(ProductAttribute entity);
}
