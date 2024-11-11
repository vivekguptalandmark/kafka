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
}
