package com.onlineShopping.CategoryService.mapper;


import com.onlineShopping.CategoryService.dto.CategoryDto;
import com.onlineShopping.CategoryService.entity.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDto dto);
    CategoryDto toDto(Category entity);
}

