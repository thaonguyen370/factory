
package com.fa.factory.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.fa.factory.admin", "com.fa.factory.common"})
@EntityScan(basePackages = {"com.fa.factory.admin", "com.fa.factory.common"})
@EnableJpaRepositories(basePackages = {"com.fa.factory.admin", "com.fa.factory.common"})
public class FactoryAdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(FactoryAdminApplication.class, args);
    }

}
