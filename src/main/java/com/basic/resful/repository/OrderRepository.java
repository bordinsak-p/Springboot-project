package com.basic.resful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.resful.entity.Orders;

public interface OrderRepository  extends JpaRepository<Orders, Integer> {
}
