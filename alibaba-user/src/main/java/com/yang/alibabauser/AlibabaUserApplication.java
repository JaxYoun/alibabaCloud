package com.yang.alibabauser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaUserApplication.class, args);
    }

}
