package com.springtutorial.blog.controllers;

import com.springtutorial.blog.payloads.ApiResponse;
import com.springtutorial.blog.payloads.CategoryDto;
import com.springtutorial.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategoryDto = this.categoryService.createCategory(categoryDto);

        return new ResponseEntity<>(createdCategoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
        CategoryDto updatedCategoryDto = this.categoryService.updateCategory(categoryDto, catId);

        return new ResponseEntity<>(updatedCategoryDto, HttpStatus.OK);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catId){
        CategoryDto fetchedCategoryDto = this.categoryService.getCategoryById(catId);

        return new ResponseEntity<>(fetchedCategoryDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> fetchedCategoryDtos = this.categoryService.getAllCategories();

        return new ResponseEntity<>(fetchedCategoryDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Integer catId){
        this.categoryService.deleteCategory(catId);

        return new ResponseEntity<>(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
    }
}
