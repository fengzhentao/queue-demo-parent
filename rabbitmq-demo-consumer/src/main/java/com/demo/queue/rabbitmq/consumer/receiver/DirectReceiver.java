package com.demo.queue.rabbitmq.consumer.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-07
 **/
@Component
@RabbitListener(queues = "testDirectQueue")
public class DirectReceiver {

    @Value("${server.port}")
    private Integer port;

    @RabbitHandler
    public void process(Map msg) {
        System.out.println("one " + port + " DirectReceiver消费者收到消息  : " + msg.toString());
    }
}
