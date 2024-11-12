package com.kafka.consumer.services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@RequiredArgsConstructor
public class ConsumerService {

//TODO: consumer need to be separate service not part of producer and need to use functional programming
    @KafkaListener(topics = "backpressure", groupId = "backpressure-consumer")
    public void backpressureInput(Message<String> msg) {
        System.out.println("Received message: " + msg.getPayload());
    }


}

