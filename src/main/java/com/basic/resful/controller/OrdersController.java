package com.basic.resful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.resful.Beans.OrdersBean;
import com.basic.resful.entity.Orders;
import com.basic.resful.services.OrdersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrder();
    }

    @GetMapping("/{id}")
    public Orders getOrdersById(@PathVariable Integer id) {
        return ordersService.getOrdersById(id);
    }
    
    @PostMapping
    public Orders createOrders(OrdersBean ordersBean) {
        return ordersService.createOrder(ordersBean);
    }
    

    
}
