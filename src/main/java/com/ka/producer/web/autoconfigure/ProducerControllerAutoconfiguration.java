package com.ka.producer.web.autoconfigure;

import com.ka.producer.web.endpoint.ProducerController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerControllerAutoconfiguration {

    @Configuration
    @ComponentScan(basePackageClasses = {ProducerController.class})
    static class EnableProducerControllers {}
}
