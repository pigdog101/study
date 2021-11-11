package com.mzw.hystrixpayment8001.service.impl;


import cn.hutool.core.util.IdUtil;
import com.mzw.hystrixpayment8001.service.GarbageCarService;
import com.mzw.mycommon.entity.GarbageCar;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * @PACKAGE_NAME: com.mzw.cloudproviderpayment8001.service.impl
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@Service
public class GarbageCarServiceImpl implements GarbageCarService {

    public String paymentOk(Integer id){
        System.out.println("payment_ok  " + id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "payment_ok  " + id;
    }
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentTimeout(Integer id){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int i = 10/0;
        System.out.println("线程池" + Thread.currentThread().getName() + "payment_timeout  " + id +  "耗时3秒");
        return "线程池" + Thread.currentThread().getName() + "payment_timeout  " + id +  "耗时3秒";
    }

    public String paymentTimeoutHandle(Integer id){
        System.out.println("线程池" + Thread.currentThread().getName() + "payment_timeout  " + "服务超时");
        return "线程池" + Thread.currentThread().getName() + "payment_timeout_handle  " + "服务超时";
    }

    //*********服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerBak",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数 10 请求 60%失败即跳闸
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(Long id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功uid：" + uuid;
    }

    public String paymentCircuitBreakerBak(Long id){
        return "id不能为负数，请重试";
    }
}
