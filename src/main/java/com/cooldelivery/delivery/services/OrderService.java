package com.cooldelivery.delivery.services;

import com.cooldelivery.delivery.modells.order.Order;
import com.cooldelivery.delivery.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order){
        orderRepository.save(order);
    }
}
