package com.mzw.payment9001.controller;

import com.mzw.mycommon.entity.CommentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PACKAGE_NAME: com.mzw.payment9001.controller
 * @AUTHOR: mzw
 * @DATE: 2021/10/8
 */
@RestController
public class NacosController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/nacos/{id}")
    public CommentResult<String> getNacos(@PathVariable("id")Long id){
        return new CommentResult<>("nacos ->" + serverPort);
    }
}
