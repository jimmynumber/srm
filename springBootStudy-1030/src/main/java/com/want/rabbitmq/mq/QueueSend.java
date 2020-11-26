package com.want.rabbitmq.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSend {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String context) {
        System.out.println("Sender : " + context);
        //使用AmqpTemplate将消息发送到消息队列QueueHello中去
        this.rabbitTemplate.convertAndSend("Queue1", context);
    }

}