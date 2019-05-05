package com.fa.factory.authentication.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryAuthenticationFeignConfiguration {

    @Bean
    public Request.Options options() {
        return new Request.Options(30000, 30000);
    }
}
