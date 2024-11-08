package com.kafka.producer.web.endpoint;

import com.kafka.producer.services.BackpressureProperties;
import com.kafka.producer.services.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;
    private final BackpressureProperties properties;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return "Message sent to Kafka!";
    }
}

