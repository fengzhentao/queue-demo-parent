package com.demo.queue.activemq.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-08
 **/
@RestController
@RequestMapping("/activemq")
public class MessageController {

    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @RequestMapping("/queue")
    public String queue(){
        jms.convertAndSend(queue, "queue message");
        return "queue 发送成功";
    }

    @JmsListener(destination = "out.queue")
    public void consumerMsgQueue(String msg){
        System.out.println(msg);
    }

    @RequestMapping("/topic")
    public String topic(){
        jms.convertAndSend(topic, "topic message");
        return "topic 发送成功";
    }

}
