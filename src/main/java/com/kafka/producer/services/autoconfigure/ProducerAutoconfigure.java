package com.kafka.producer.services.autoconfigure;

import com.kafka.producer.services.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
@Configuration
@EnableBinding({BackpressureProducer.class, BackpressureConsumer.class})
@EnableConfigurationProperties({BackpressureProperties.class})
public class ProducerAutoconfigure {



    @Bean
    ProducerService producerService(BackpressureProducer backpressureProducer) {
        return new ProducerService(backpressureProducer);
    }


    @Bean
    public BackpressureListener backPressureListener() {
        return new BackpressureListener();

    }
}
