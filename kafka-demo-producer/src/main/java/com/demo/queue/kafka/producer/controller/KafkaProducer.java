package com.demo.queue.kafka.producer.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2020-12-09
 **/
@RestController
@RequestMapping("/kafka")
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/sendMsg")
    public String msg() {
        kafkaTemplate.send("topic1", "producer send message");
        return "ok";
    }

    @KafkaListener(topics = "topic1")
    public void listenMsg (ConsumerRecord<String,String> record) {
        String value = record.value();
        System.out.println("ConsumerMsg====>>"+value);
    }
}
