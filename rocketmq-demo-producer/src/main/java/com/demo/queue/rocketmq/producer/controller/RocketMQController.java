package com.demo.queue.rocketmq.producer.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-10
 **/
@RestController
@RequestMapping("/rocketMQ")
public class RocketMQController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/sendMsg")
    public String sendMsg() {
        rocketMQTemplate.syncSend("top-rocketmq", "hello rocketMQ");
        return "ok";
    }
}
