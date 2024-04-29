package com.springtutorial.blog.services;

import com.springtutorial.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto category);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    CategoryDto getCategoryById(Integer categoryId);
    List<CategoryDto> getAllCategories();
    void deleteCategory(Integer categoryId);
}
