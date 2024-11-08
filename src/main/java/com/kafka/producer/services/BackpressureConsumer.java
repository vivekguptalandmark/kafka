package com.kafka.producer.services;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface BackpressureConsumer {
    String CHANNEL = "backpressureInput";

    @Input(CHANNEL)
    MessageChannel backpressureInput();
}
