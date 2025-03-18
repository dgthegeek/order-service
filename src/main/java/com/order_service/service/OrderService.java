package com.order_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.order_service.dto.OrderRequest;
import com.order_service.model.Order;
import com.order_service.repository.Repository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

    private final Repository repository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        System.out.println(order.getOrderNumber());
        order.setSkiCode(orderRequest.skiCode());
        order.setQuantity(orderRequest.quantity());
        order.setPrice(orderRequest.price());


        repository.save(order);
    }
    

}
