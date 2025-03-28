package com.order_service.service;

import java.util.UUID;

import com.order_service.client.InventoryClient;
import org.springframework.stereotype.Service;

import com.order_service.dto.OrderRequest;
import com.order_service.model.Order;
import com.order_service.repository.Repository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

    private final Repository repository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {

        var isProductInStock = inventoryClient.isInStock(orderRequest.skiCode(), orderRequest.quantity());

        if (isProductInStock) {

            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            System.out.println(order.getOrderNumber());
            order.setSkiCode(orderRequest.skiCode());
            order.setQuantity(orderRequest.quantity());
            order.setPrice(orderRequest.price());
            repository.save(order);
        }else {
            throw  new RuntimeException( "Product with skiCode " + orderRequest.skiCode() + " is not in stock" );
        }
    }
    

}
