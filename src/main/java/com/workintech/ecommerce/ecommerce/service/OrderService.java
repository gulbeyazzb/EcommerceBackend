package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.dto.response.OrderResponse;
import com.workintech.ecommerce.ecommerce.dto.response.ProductsResponseForOrder;
import com.workintech.ecommerce.ecommerce.entity.Order;

public interface OrderService {
    OrderResponse saveOrder(Order order);

}
