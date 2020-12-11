package com.demo.queue.activemq.consumer.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-08
 **/
@Component
public class TopicListener2 {

    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        System.out.println("TopicListener: consumer-b 收到一条信息: " + text);
    }
}
