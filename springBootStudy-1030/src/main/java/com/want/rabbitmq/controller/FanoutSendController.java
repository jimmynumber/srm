package com.want.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.rabbitmq.mq.FanoutSender;

@RestController
public class FanoutSendController {
	@Autowired
	private FanoutSender sender;

	@GetMapping("/FanoutSend")
	public void fanoutSender() throws Exception {
		sender.send();
	}

}
