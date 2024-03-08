package com.basic.resful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.resful.Beans.OrdersBean;
import com.basic.resful.entity.Orders;
import com.basic.resful.repository.OrderRepository;

@Service
public class OrdersService {
    @Autowired
    OrderRepository orderRepository;

    public List<Orders> getAllOrder() {
        return orderRepository.findAll();
    } 

    public Orders getOrdersById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Orders createOrder(OrdersBean ordersBean) {
        Orders orders = new Orders();

        try {
            orders.setTableFood(ordersBean.getTableFood());
            orders.setFoodMenu(ordersBean.getFoodMenu());
            orders.setStatus(ordersBean.getStatus());
            orders.setQuantity(ordersBean.getQuantity());
            orders.setTotalprice(ordersBean.getTotalprice());    
        } catch (Exception e) {
            // TODO: handle exception
        }

        return orderRepository.save(orders);
    }

    
}
