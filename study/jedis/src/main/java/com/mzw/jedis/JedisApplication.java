package com.mzw.jedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mzw"})
public class JedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(JedisApplication.class, args);
    }

}
