package com.workintech.ecommerce.ecommerce.controller;

import com.workintech.ecommerce.ecommerce.entity.Order;
import com.workintech.ecommerce.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public void saveOrder(Order order) {
        orderService.saveOrder(order);
    }


}
