package com.mzw.cloudpayment8001;

import com.mzw.cloudpayment8001.dao.GarbageCarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CloudPrividerPayment8001ApplicationTests {
    @Autowired
    private GarbageCarMapper garbageCarMapper;
    @Test
    void contextLoads() {
        System.out.println(garbageCarMapper.selectByPrimaryKey(5));
    }

}
