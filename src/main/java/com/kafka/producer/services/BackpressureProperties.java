package com.kafka.producer.services;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.kafka")
public class BackpressureProperties {

    private String bootstrapServers;
}
