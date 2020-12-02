package com.example.order.Service;

import com.example.order.Entity.Order;

import java.util.Map;

public interface OrderService {
    Map<String, Object> createOrder(String sku_id, String user_id);

    Map<String, Object> insertOrder(Order order);
}
