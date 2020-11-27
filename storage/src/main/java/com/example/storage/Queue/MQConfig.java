package com.example.storage.Queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.Binding.DestinationType.QUEUE;

@Configuration
public class MQConfig {

    @Bean
    public Queue queueStorage(){
         return new Queue("storage_queue", true);
    }
}
