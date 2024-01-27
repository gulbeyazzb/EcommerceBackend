package com.workintech.ecommerce.ecommerce.repository;

import com.workintech.ecommerce.ecommerce.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct,Long> {
}
