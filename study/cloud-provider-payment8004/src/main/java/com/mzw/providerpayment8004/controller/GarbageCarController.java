package com.mzw.providerpayment8004.controller;

import com.mzw.mycommon.entity.CommentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PACKAGE_NAME: com.mzw.cloudpayment8001.controller
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@RestController
public class GarbageCarController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/zoo")
    public CommentResult<String> getCar(){
        return new CommentResult<String>(200,"查询成功  ->" + serverPort ,"测试zoo");
    }
}
