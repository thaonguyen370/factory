package com.fa.factory.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.fa.factory.admin.interfaces"})
@ComponentScan(basePackages = {"com.fa.factory.configuration", "com.fa.factory.common"})
@EntityScan(basePackages = {"com.fa.factory.configuration", "com.fa.factory.common"})
public class FactoryConfigurationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryConfigurationServiceApplication.class, args);
    }
}
