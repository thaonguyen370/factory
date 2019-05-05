package com.fa.factory.configuration.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfigurationFeignConfiguration {

    @Bean
    public Request.Options options() {
        return new Request.Options(30000, 30000);
    }
}
