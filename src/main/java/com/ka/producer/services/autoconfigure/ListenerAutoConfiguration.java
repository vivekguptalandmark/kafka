package com.ka.producer.services.autoconfigure;

import com.ka.producer.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@AutoConfigureAfter(ProducerAutoconfigure.class)
@Configuration
public class ListenerAutoConfiguration {

    @Autowired
    private ConsumerService consumerService;  // Inject your business service to process the message

    // Define the Consumer bean for listening to messages from 'bps-topic'
    @Bean
    public Consumer<Message<String>> bpInputConsumer    () {
        return message -> {
            // Process the message with your business logic
            consumerService.performBusinessLogic(message.getPayload());
        };
    }
}