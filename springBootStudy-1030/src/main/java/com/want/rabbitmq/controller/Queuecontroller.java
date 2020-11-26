package com.want.rabbitmq.controller;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.rabbitmq.mq.QueueSend;

@RestController
@RequestMapping("/Queuecontroller")
public class Queuecontroller {
	@Autowired
	private QueueSend queueSend;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@GetMapping("/sendQueue")
	public String sendQueue() {
		int i = 5;
		for (int j = 0; j < i; j++) {
			String msg = "Queue1 msg" + j + new Date();
			try {
				queueSend.send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "sendQueue";
	}

	@GetMapping("/sendQueue1")
	public String sendQueue1() {
		Message message = MessageBuilder.withBody("body content000".getBytes())
				.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).setMessageId("1")
				.setHeader("header", "header").build();
		amqpTemplate.send("Queue1", message);
		amqpTemplate.convertAndSend("Queue1", "body content111");
		return "sendQueue1";
	}

}
