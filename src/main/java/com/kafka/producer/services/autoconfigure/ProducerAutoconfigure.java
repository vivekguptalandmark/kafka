package com.kafka.producer.services.autoconfigure;

import com.kafka.producer.services.ProducerService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class ProducerAutoconfigure {



    @Bean
    ProducerService producerService(StreamBridge streamBridge) {
        return new ProducerService(streamBridge);
    }

//    @Bean
//    public Consumer<Message<String>> backpressureInputListener() {
//        return message -> {
//            // Process the incoming message
//            System.out.println("Received message: " + message.getPayload());
//        };
//    }
}
