package com.mzw.consumerfeign.Controller;


import com.google.inject.internal.cglib.core.$Constants;
import com.mzw.consumerfeign.service.GarbageCarService;
import com.mzw.mycommon.entity.CommentResult;
import com.mzw.mycommon.entity.GarbageCar;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @PACKAGE_NAME: com.mzw.cloudorder80.Controller
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@RestController
@DefaultProperties(defaultFallback = "hystrixPaymentOkFallbackMethod")
public class OrderController {
    @Resource
    private GarbageCarService garbageCarService;

    @GetMapping("/order/hystrix/timeout/{id}")
    public CommentResult<String> hystrixPaymentTimeout(@PathVariable Integer id){
        CommentResult forObject = garbageCarService.hystrixTimeout(id);
        return forObject;
    }
//    @HystrixCommand(fallbackMethod = "hystrixPaymentOkFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @GetMapping("/order/hystrix/ok/{id}")
    @HystrixCommand
    public CommentResult<String> hystrixPaymentOk(@PathVariable Integer id){
        CommentResult forObject = garbageCarService.hystrixOk(id);
        return forObject;
    }

    public CommentResult<String> hystrixPaymentOkFallbackMethod(){
        CommentResult<String> commentResult = new CommentResult<>();
        commentResult.setCode(200);
        commentResult.setData("消费测" + "payment_timeout_handle  " + "服务超时");
        return commentResult;
    }
}
