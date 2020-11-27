package com.example.storage.Queue;

import com.example.storage.Service.StorageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Component
public class StorageQueue {
    @Autowired
    StorageService storageService;

    @RabbitListener(queues = "storage_queue")
    public void insertStorage(String msg){
        System.out.println("storage_queue接受消息：" + msg);

        Map<String, Object> res = new HashMap<>();
        res = storageService.insertStorage(new BigInteger(msg), BigInteger.ONE, BigDecimal.ZERO, BigDecimal.ONE);

    }
}
