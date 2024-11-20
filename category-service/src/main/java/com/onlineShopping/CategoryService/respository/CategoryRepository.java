package com.onlineShopping.CategoryService.respository;

import com.onlineShopping.CategoryService.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}
