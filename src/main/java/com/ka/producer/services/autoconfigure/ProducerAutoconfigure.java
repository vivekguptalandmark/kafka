package com.ka.producer.services.autoconfigure;

import com.ka.producer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class ProducerAutoconfigure {
    // Inject StreamBridge to allow dynamic message sending to Kafka
    @Autowired
    private StreamBridge streamBridge;

    @Bean
    public MessageChannel backpressureOutput() {
        return new DirectChannel();
    }

    @Bean
    ProducerService producerService(StreamBridge streamBridge) {
        return new ProducerService(streamBridge);
    }
}
