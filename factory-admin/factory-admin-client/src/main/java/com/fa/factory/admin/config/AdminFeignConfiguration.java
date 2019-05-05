package com.fa.factory.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;

@Configuration
public class AdminFeignConfiguration {

    @Bean
    public Request.Options options() {
        return new Request.Options(30000, 30000);
    }

}
