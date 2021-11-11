package com.mzw.providerpayment8002.controller;

import com.mzw.mycommon.entity.CommentResult;
import com.mzw.mycommon.entity.GarbageCar;
import com.mzw.providerpayment8002.service.GarbageCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @PACKAGE_NAME: com.mzw.cloudpayment8001.controller
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@RestController
public class GarbageCarController {
    @Autowired
    private GarbageCarService garbageCarService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommentResult<GarbageCar> getCar(@PathVariable Integer id){
        return new CommentResult<GarbageCar>(200,"查询成功  ->" + serverPort ,garbageCarService.selectByPrimaryKey(id));
    }

    @GetMapping("/payment/lb/{id}")
    public CommentResult<String> getCarLb(@PathVariable Integer id){
        return new CommentResult<String>(200,"查询成功  ->" + serverPort ,"test");
    }
}
