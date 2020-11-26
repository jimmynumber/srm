package com.want.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectConfig {
     @Bean
     public Queue objectQueue() {
         return new Queue("object");
     }
}