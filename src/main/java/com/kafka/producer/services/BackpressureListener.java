package com.kafka.producer.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@Slf4j
public class BackpressureListener {

    @StreamListener(BackpressureConsumer.CHANNEL)
    public void listen(Message<String> message) {
       log.info("processing message inside listener: "+ message.getPayload());
    }
}
