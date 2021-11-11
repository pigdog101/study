package com.mzw.consumerfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PACKAGE_NAME: com.mzw.consumerfeign.config
 * @AUTHOR: mzw
 * @DATE: 2021/9/27
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
