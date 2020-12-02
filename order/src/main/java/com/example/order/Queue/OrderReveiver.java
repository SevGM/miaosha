package com.example.order.Queue;

import com.example.order.Dao.OrderMapper;
import com.example.order.Entity.Order;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.example.order.Queue.RabbitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderReveiver {
    @Autowired
    OrderMapper orderMapper;

    @Transactional
    @RabbitListener(queues = RabbitConfig.orderQueue)
    public void insertOrder(Order order){
        orderMapper.insertOrder(order);
        System.out.println("插入成功！");
    }
}
