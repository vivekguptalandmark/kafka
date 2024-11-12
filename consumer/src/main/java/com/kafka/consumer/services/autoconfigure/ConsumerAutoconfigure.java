package com.kafka.consumer.services.autoconfigure;

import com.kafka.consumer.services.ConsumerService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
public class ConsumerAutoconfigure {

    @Bean
    ConsumerService consumerService() {
        return new ConsumerService();
    }
}
