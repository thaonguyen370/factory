package com.fa.factory.authentication.interfaces;

import org.springframework.cloud.openfeign.FeignClient;

import com.fa.factory.authentication.config.FactoryAuthenticationFeignConfiguration;

@FeignClient(value = "factory-authentication", configuration = FactoryAuthenticationFeignConfiguration.class)
public interface FactoryAuthenticationClient {
}
