package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.request.OrderRequest;
import com.workintech.ecommerce.ecommerce.dto.response.OrderResponse;
import com.workintech.ecommerce.ecommerce.entity.Order;
import com.workintech.ecommerce.ecommerce.entity.Products;
import com.workintech.ecommerce.ecommerce.repository.OrderRespository;
import com.workintech.ecommerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRespository orderRespository;
    private ModelMapperService modelMapperService;
    private ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRespository orderRespository,ModelMapperService modelMapperService,ProductRepository productRepository) {
        this.orderRespository = orderRespository;
        this.modelMapperService=modelMapperService;
        this.productRepository=productRepository;
    }

    @Override
    public OrderResponse saveOrder(OrderRequest orderRequest) {
        Order order= modelMapperService.forRequest().map(orderRequest, Order.class);
        List<Products> productsList=order.getProducts();
        order.setProducts(null);
        Order savedOrder=orderRespository.save(order);
        savedOrder.setProducts(productsList);
        orderRespository.save(savedOrder);
        return modelMapperService.forResponse().map(savedOrder, OrderResponse.class);
    }


}
