package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.dto.request.OrderRequest;
import com.workintech.ecommerce.ecommerce.dto.response.OrderResponse;
import com.workintech.ecommerce.ecommerce.entity.Order;

public interface OrderService {
    OrderResponse saveOrder(OrderRequest orderRequest);

}
