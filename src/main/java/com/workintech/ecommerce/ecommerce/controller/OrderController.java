package com.workintech.ecommerce.ecommerce.controller;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.request.OrderRequest;
import com.workintech.ecommerce.ecommerce.dto.response.OrderResponse;
import com.workintech.ecommerce.ecommerce.entity.Order;
import com.workintech.ecommerce.ecommerce.entity.Products;
import com.workintech.ecommerce.ecommerce.service.OrderService;
import com.workintech.ecommerce.ecommerce.service.OrderedProductService;
import com.workintech.ecommerce.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    private OrderedProductService orderedProductService;
    private ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, OrderedProductService orderedProductService,
                           ProductService productService) {
        this.orderService = orderService;
        this.productService=productService;
        this.orderedProductService = orderedProductService;
    }

    @PostMapping("/")
    public OrderResponse saveOrder(@RequestBody OrderRequest order) {

        return orderService.saveOrder(order);
    }


}
