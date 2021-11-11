package com.mzw.hystrixpayment8001.controller;

import com.mzw.hystrixpayment8001.service.GarbageCarService;
import com.mzw.mycommon.entity.CommentResult;
import com.mzw.mycommon.entity.GarbageCar;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @PACKAGE_NAME: com.mzw.cloudpayment8001.controller
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@RestController
public class GarbageCarController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Resource
    private GarbageCarService garbageCarService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public CommentResult<String> hystrixOk(@PathVariable Integer id){
        return new CommentResult<String>(200,"查询成功  ->" + serverPort ,garbageCarService.paymentCircuitBreaker(id.longValue()));
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public CommentResult<String> hystrixTimeout(@PathVariable Integer id){
        return new CommentResult<String>(200,"查询成功  ->" + serverPort ,garbageCarService.paymentTimeout(id));
    }

    @GetMapping("/payment/get/{id}")
    public CommentResult<String> hystrixGet(@PathVariable Integer id){
        return new CommentResult<String>(200,"查询成功  ->" + serverPort ,garbageCarService.paymentCircuitBreaker(id.longValue()));
    }
}
