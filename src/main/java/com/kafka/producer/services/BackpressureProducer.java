package com.kafka.producer.services;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BackpressureProducer {
    String CHANNEL = "backpressureOutput";

    @Output(CHANNEL)
    MessageChannel backpressureOutput();
}
