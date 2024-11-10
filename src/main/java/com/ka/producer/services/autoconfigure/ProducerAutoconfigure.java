package com.ka.producer.services.autoconfigure;

import com.ka.producer.services.ConsumerService;
import com.ka.producer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class ProducerAutoconfigure {
    // Inject StreamBridge to allow dynamic message sending to Kafka
    @Autowired
    private StreamBridge streamBridge;

    @Bean
    ProducerService producerService(StreamBridge streamBridge) {
        return new ProducerService(streamBridge);
    }

    @Bean
    ConsumerService consumerService() {
        return new ConsumerService();
    }



}
