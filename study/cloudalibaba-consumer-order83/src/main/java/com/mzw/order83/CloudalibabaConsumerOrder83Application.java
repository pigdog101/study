package com.mzw.order83;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudalibabaConsumerOrder83Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConsumerOrder83Application.class, args);
    }

}
