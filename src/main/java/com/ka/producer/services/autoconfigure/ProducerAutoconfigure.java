package com.ka.producer.services.autoconfigure;

import com.ka.producer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.function.Consumer;

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
