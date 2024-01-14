package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.dto.response.CategoryResponse;
import com.workintech.ecommerce.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
    Category getCategoryByID(long id);
    CategoryResponse save(Category category);


}
