package com.ka.producer.services;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;

public class ProducerService {

    @Getter(AccessLevel.PROTECTED)
    private final StreamBridge streamBridge;


    public ProducerService (StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void sendMessage(String message) {
        streamBridge.send("backpressur",MessageBuilder.withPayload(message).build());
    }
}

