package com.want.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.entity.User;
import com.want.rabbitmq.mq.ObjectSender;

@RestController
public class ObjectSendController {
	@Autowired
	private ObjectSender objectSender;

	@GetMapping("/sendOject")
	public String sendOjectController() {
		try {
			User user = new User();
			user.setName("longzhiran");
			user.setAge(18);
			objectSender.send(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "执行失败";
		}
		return "执行成功";
	}
}
