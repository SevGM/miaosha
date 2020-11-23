package com.example.storage.Queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StorageQueue {
    @RabbitListener(queues = "storage_queue")
    public void insertStorage(String msg){
        //TODO: meixie
    }
}
