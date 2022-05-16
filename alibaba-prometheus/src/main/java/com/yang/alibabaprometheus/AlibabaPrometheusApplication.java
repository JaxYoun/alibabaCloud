package com.yang.alibabaprometheus;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlibabaPrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaPrometheusApplication.class, args);
    }

    /**
     * 应用在prometheus中显示的应用名
     *
     * @param applicationName 应用名
     * @return
     */
    @Bean
    public MeterRegistryCustomizer<MeterRegistry> go(@Value("${spring.application.name}") String applicationName) {
        return (it) -> it.config().commonTags("application", applicationName);
    }

}
