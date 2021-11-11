package com.mzw.cloudorder80.Controller;


import com.mzw.mycommon.entity.CommentResult;
import com.mzw.mycommon.entity.GarbageCar;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OrderController {
//    private final static String url = "http://localhost:8001";
    private final static String url = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/get/{id}")
    public CommentResult<GarbageCar> getCar(@PathVariable Integer id){
        CommentResult forObject = restTemplate.getForObject(url + "/payment/get/" + id, CommentResult.class, 5);
        return forObject;
    }
}
