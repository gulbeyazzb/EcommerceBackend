package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.entity.OrderedProduct;

import java.util.List;

public interface OrderedProductService {
    OrderedProduct saveOrderedProduct(OrderedProduct orderedProduct);
    List<OrderedProduct> getAllProducts();
}
