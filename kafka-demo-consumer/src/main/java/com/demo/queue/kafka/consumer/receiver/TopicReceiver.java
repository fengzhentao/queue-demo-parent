package com.demo.queue.kafka.consumer.receiver;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-10
 **/
@Component
public class TopicReceiver {

    @KafkaListener(topics = "topic1")
    public void listenMsg (ConsumerRecord<String,String> record) {
        String value = record.value();
        System.out.println("ConsumerMsg====>>"+value);
    }
}
