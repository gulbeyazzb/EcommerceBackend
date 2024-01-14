package com.workintech.ecommerce.ecommerce.repository;


import com.workintech.ecommerce.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
