package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.CategoryResponse;
import com.workintech.ecommerce.ecommerce.entity.Category;
import com.workintech.ecommerce.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return Converter.findCategories(categoryRepository.findAll());
    }

    @Override
    public Category getCategoryByID(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            return categoryOptional.get();
        }
        throw new CommerceException("Category not found!", HttpStatus.NOT_FOUND);
    }

    @Override
    public CategoryResponse save(Category category) {
        Category saved = categoryRepository.save(category);
        return new CategoryResponse(category.getId(), category.getCode(), category.getTitle(),
                category.getImg(), category.getRating(), category.getGender());
    }
}
