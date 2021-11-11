package com.mzw.consumerzkorder80.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @PACKAGE_NAME: com.mzw.cloudorder80.Config
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@Configuration
public class ContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
