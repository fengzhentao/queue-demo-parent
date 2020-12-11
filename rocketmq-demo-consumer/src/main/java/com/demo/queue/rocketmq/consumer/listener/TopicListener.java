package com.demo.queue.rocketmq.consumer.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-11
 **/
@Component
@RocketMQMessageListener(consumerGroup = "consumer_group_test", topic = "top-rocketmq")
public class TopicListener implements RocketMQListener {

    @Override
    public void onMessage(Object o) {
        if (o instanceof String) {
            System.out.println("StringListener receiver message:" + o);
        }
    }
}
