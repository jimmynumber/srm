package com.want.rabbitmq.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.want.entity.User;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

	@RabbitHandler
	public void process(User user) {
		System.out.println("Receiver object : " + user);
	}

}