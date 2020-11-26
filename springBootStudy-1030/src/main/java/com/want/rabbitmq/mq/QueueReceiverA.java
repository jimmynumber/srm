package com.want.rabbitmq.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Queue1")//监听QueueHello的消息队列
public class QueueReceiverA {
    @RabbitHandler//@RabbitHandler来实现具体消费
    public void QueueReceiver(String Queue1) {
        System.out.println("Receiver A: " + Queue1);
    }

}
