package com.kafka.consumer.services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@RequiredArgsConstructor
@Slf4j
public class ConsumerService {

    public void processMessage(Message<String> msg) {

        try {
            Thread.sleep(2000);
                log.info("Received message in listener: " + msg.getPayload());
            Acknowledgment acknowledgment =
                    msg.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
            acknowledgment.acknowledge();
        } catch (InterruptedException e) {
           log.error(e.getMessage());
        }
    }
}

