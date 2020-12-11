package com.demo.queue.activemq.consumer.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-08
 **/
//@Component
public class QueueListener2 {

    @JmsListener(destination = "publish.queue", containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")
    public String receive(String text){
        System.out.println("QueueListener: consumer-b 收到一条信息: " + text);
        return "consumer-b received : " + text;
    }
}
