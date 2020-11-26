package com.want.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public Queue queueA() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue queueB() {
        return new Queue("fanout.B");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue queueA, FanoutExchange fanoutExchanger) {
        return BindingBuilder.bind(queueA).to(fanoutExchanger);
    }

    @Bean
    Binding bindingExchangeB(Queue queueB, FanoutExchange fanoutExchanger) {
        return BindingBuilder.bind(queueB).to(fanoutExchanger);
    }

   
}
