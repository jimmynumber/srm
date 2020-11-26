package com.want.rabbitmq.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.rabbitmq.mq.CustomSender;

 
@RestController
@RequestMapping
public class CustomController {
  @Autowired
  private CustomSender customSender;

    @GetMapping("/customSend")
    public void send() {
        customSender.sendMsg("delay_queue_1","11111");
    }
}
