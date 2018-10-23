package com.nmkip.fruitshop.controller;

import com.nmkip.fruitshop.dto.CategoriesDTO;
import com.nmkip.fruitshop.exception.CategoryNotFoundException;
import com.nmkip.fruitshop.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public CategoriesDTO getCategories() {
        return new CategoriesDTO(categoryService.findAll());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleCategoryNotFound() {
    }
}
