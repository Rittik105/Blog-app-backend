package com.springtutorial.blog.services.impls;

import com.springtutorial.blog.entities.Category;
import com.springtutorial.blog.exceptions.ResourceNotFound;
import com.springtutorial.blog.payloads.CategoryDto;
import com.springtutorial.blog.repositories.CategoryRepo;
import com.springtutorial.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category savedCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category fetchedCategory = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFound("Category", "Id", categoryId));

        fetchedCategory.setTitle(categoryDto.getTitle());
        fetchedCategory.setDescription(categoryDto.getDescription());

        Category savedCategory = this.categoryRepo.save(fetchedCategory);

        return this.modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category fetchedCategory = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFound("Category", "Id", categoryId));

        return this.modelMapper.map(fetchedCategory, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> fetchedCategories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        fetchedCategories.forEach(
                category -> categoryDtos.add(this.modelMapper.map(category, CategoryDto.class))
        );

        return categoryDtos;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category fetchedCategory = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFound("Category", "Id", categoryId));

        this.categoryRepo.delete(fetchedCategory);
    }
}
