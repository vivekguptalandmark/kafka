package com.kafka.consumer.services.autoconfigure;

import com.kafka.consumer.services.ConsumerService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import java.util.function.Consumer;

@Configuration
public class ConsumerAutoconfigure {

    @Bean
    public Consumer<Message<String>> backpressureInput(ConsumerService backpressureService) {
        return message -> backpressureService.processMessage(message);
    }

    @Bean
    ConsumerService consumerService() {
        return new ConsumerService();
    }
}
