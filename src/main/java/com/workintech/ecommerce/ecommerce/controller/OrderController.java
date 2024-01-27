package com.workintech.ecommerce.ecommerce.controller;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.OrderResponse;
import com.workintech.ecommerce.ecommerce.entity.Order;
import com.workintech.ecommerce.ecommerce.entity.Products;
import com.workintech.ecommerce.ecommerce.service.OrderService;
import com.workintech.ecommerce.ecommerce.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    private OrderedProductService orderedProductService;

    @Autowired
    public OrderController(OrderService orderService, OrderedProductService orderedProductService) {
        this.orderService = orderService;
        this.orderedProductService = orderedProductService;
    }

    @PostMapping("/")
    public OrderResponse saveOrder(@RequestBody Order order) {
        List<Products> productsList = order.getProducts();

        for (Products product : productsList) {
            order.addProduct(product);
        }

        return orderService.saveOrder(order);
    }


}
