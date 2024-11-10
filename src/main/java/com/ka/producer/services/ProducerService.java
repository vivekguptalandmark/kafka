package com.ka.producer.services;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;


public class ProducerService {

    public ProducerService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Getter(AccessLevel.PROTECTED)
    private final StreamBridge streamBridge;



    public void sendMessage(String message) {
        streamBridge.send("bpOutputProducer-out-0",MessageBuilder.withPayload(message).build());
    }


}

