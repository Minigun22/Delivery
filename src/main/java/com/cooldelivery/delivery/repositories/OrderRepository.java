package com.cooldelivery.delivery.repositories;

import com.cooldelivery.delivery.modells.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
