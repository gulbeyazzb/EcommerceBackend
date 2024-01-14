package com.workintech.ecommerce.ecommerce.controller;

import com.workintech.ecommerce.ecommerce.dto.response.CategoryResponse;
import com.workintech.ecommerce.ecommerce.entity.Category;
import com.workintech.ecommerce.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/")
    public CategoryResponse save(@RequestBody Category category) {
        return categoryService.save(category);
    }

}
