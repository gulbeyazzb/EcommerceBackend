package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.entity.Order;
import com.workintech.ecommerce.ecommerce.entity.Products;
import com.workintech.ecommerce.ecommerce.repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRespository orderRespository;
@Autowired
    public OrderServiceImpl() {
    }

    @Override
    public void saveOrder(Order order) {
        orderRespository.save(order);
    }


}
