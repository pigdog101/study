package com.mzw.jedis;

import com.mzw.jedis.service.impl.RedisServiceImpl;
import com.mzw.jedis.util.RedisTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
class JedisApplicationTests {


    @Autowired
    private RedisServiceImpl redisService;

    @Test
    void contextLoads() {
        new Thread(()->{
            for (int i = 0; i < 800; i++) {
                redisService.getGoods();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 800; i++) {
                redisService.getGoods();
            }
        },"BB").start();

        while (true){

        }
    }
    @Test
    void contextLoads1() {
        new Thread(()->{
            for (int i = 0; i < 800; i++) {
                redisService.getGoods();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 800; i++) {
                redisService.getGoods();
            }
        },"BB").start();

        while (true){

        }
    }

}
