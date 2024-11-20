package com.onlineShopping.CategoryService.service;


import com.onlineShopping.CategoryService.dto.CategoryDto;
import com.onlineShopping.CategoryService.entity.Category;
import com.onlineShopping.CategoryService.mapper.CategoryMapper;
import com.onlineShopping.CategoryService.respository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    public CategoryDto addCategory(CategoryDto categoryDto) {
        if (categoryRepository.existsByName(categoryDto
                .getName())) {
            throw new RuntimeException("Category already exists with name: " + categoryDto.getName());
        }
        Category category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
