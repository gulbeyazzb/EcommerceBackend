package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.OrderResponse;
import com.workintech.ecommerce.ecommerce.entity.Order;
import com.workintech.ecommerce.ecommerce.entity.Products;
import com.workintech.ecommerce.ecommerce.repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRespository orderRespository;

    @Autowired
    public OrderServiceImpl(OrderRespository orderRespository) {
        this.orderRespository = orderRespository;
    }

    @Override
    public OrderResponse saveOrder(Order order) {
        return Converter.findOrder(orderRespository.save(order));
    }


}
