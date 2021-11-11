package com.mzw.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mzw"})
public class RabbitMqApp {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApp.class,args);
    }
}
