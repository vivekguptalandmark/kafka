package com.kafka.consumer.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ConsumerService {

    @Bean
    public Consumer<String> processMessage() {
        return message -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Received message: " + message);
        };
    }

}

