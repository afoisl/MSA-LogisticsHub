package com.logistics.order.infrastructure.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductFeignClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomProductErrorDecoder();
    }

}
