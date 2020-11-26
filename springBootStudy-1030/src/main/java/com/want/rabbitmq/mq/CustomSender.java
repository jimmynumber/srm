package com.want.rabbitmq.mq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomSender {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(String queueName, String msg) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Sender:" + sdf.format(new Date()));
		rabbitTemplate.convertAndSend("delayed_exchange", queueName, msg, new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				//
				//message.getMessageProperties().setHeader("x-delay", 100);
				return message;
			}
		});
		
//		rabbitTemplate.convertAndSend("delayed_exchange", queueName, msg,(message)->{
//			 message.getMessageProperties().setHeader("x-delay", 5000);
//			 return message;
//		});
	}
}
