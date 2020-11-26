package com.want.rabbitmq.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.rabbitmq.mq.TopicSender;


@RestController
@RequestMapping("TopicSendController")
public class TopicSendController {
    @Autowired
    private TopicSender sender;

   @GetMapping("topicsend")
    public String  topic() throws Exception {
        sender.send();
        return "topicsend";
    }

    @GetMapping("topicsend2")
    public String topic1() throws Exception {
        sender.send2();
        return "topicsend2";
    }

    @GetMapping("topicsend3")
    public String topic2() throws Exception {
        sender.send3();
        return "topicsend3";
    }
}
