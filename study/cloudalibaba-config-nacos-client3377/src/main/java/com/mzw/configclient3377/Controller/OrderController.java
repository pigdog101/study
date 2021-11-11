package com.mzw.configclient3377.Controller;


import com.mzw.mycommon.entity.CommentResult;
import com.mzw.mycommon.entity.GarbageCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @PACKAGE_NAME: com.mzw.cloudorder80.Controller
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@RestController
@RefreshScope
public class OrderController {
//    private final static String url = "http://localhost:8001";
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/nacos/config")
    public String getCar(){
        return configInfo;
    }
}
