package com.yang.alibabaorder.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {

    @Bean
    public Request.Options options() {
        return new Request.Options(60000, 60000);
    }

}
