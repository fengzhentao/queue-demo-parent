package com.demo.queue.activemq.consumer.listener;

import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-08
 **/
//@Component
public class QueueListener {

    @JmsListener(destination = "publish.queue", containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")
    public String receive(ActiveMQMessage mqMessage, Session session){
        String value = "";
        try {
            System.out.println(session.getAcknowledgeMode());
            System.out.println(session.getTransacted());
            Enumeration propertyNames = mqMessage.getPropertyNames();
            while (propertyNames.hasMoreElements()) {
                System.out.println(mqMessage.getProperty((String) propertyNames.nextElement()));
            }
            value = mqMessage.getStringProperty("value");
            System.out.println("QueueListener: consumer-a 收到一条信息: " + value);
            mqMessage.acknowledge();
        } catch (JMSException | IOException e) {
            e.printStackTrace();
        }
        return "consumer-a received : " + value;
    }
}
