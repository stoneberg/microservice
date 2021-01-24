package com.stone.order.service.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stone.order.service.ms.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
