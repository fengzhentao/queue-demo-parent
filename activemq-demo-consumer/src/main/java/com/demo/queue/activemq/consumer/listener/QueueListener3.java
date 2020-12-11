package com.demo.queue.activemq.consumer.listener;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-08
 **/
@Component
public class QueueListener3 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("QueueListener: consumer-c 收到一条信息: " + message);
        try {
            message.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
