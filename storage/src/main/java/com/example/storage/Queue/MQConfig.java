package com.example.storage.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

import static org.springframework.amqp.core.Binding.DestinationType.QUEUE;

@Configuration
public class MQConfig {

//    @Bean
//    public Queue queueStorage(){
//            return new Queue(QUEUE, true);
//    }
}
