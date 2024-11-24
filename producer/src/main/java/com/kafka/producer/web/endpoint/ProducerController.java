package com.kafka.producer.web.endpoint;

import com.kafka.producer.services.ProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        for (int i=0; i< 100000;i++)
        {
            producerService.sendMessage(message + i);
        }

        return "Message sent to Kafka!";
    }
}

