package com.fa.factory.configuration.interfaces;

import org.springframework.cloud.openfeign.FeignClient;

import com.fa.factory.configuration.config.FactoryConfigurationFeignConfiguration;

@FeignClient(value = "factory-configuration", configuration = FactoryConfigurationFeignConfiguration.class)
public interface FactoryConfigurationClient {
}
