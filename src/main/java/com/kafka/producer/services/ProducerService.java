package com.kafka.producer.services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class ProducerService {

    @Getter(AccessLevel.PROTECTED)
    private final BackpressureProducer backpressureProducer;



    public void sendMessage(String message) {
        backpressureProducer.backpressureOutput().send(MessageBuilder.withPayload(message).build());
    }
}

