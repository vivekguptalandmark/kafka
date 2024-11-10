package com.ka.producer.services;

import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    // Your business logic
    public void performBusinessLogic(String payload) {
        System.out.println("Received message: " + payload);
    }
}