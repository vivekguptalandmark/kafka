package com.kafka.producer.services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class ProducerService {

    @Getter(AccessLevel.PROTECTED)
    private final StreamBridge streamBridge;


    public void sendMessage(String message) {
        streamBridge.send("backpressureOutput", MessageBuilder.withPayload(message).build());
    }




}

