package com.mzw.configclient3377;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaConfigNacosClient3377Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConfigNacosClient3377Application.class, args);
    }

}
