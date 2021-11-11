package com.mzw.cloudpayment8001.controller;

import com.mzw.cloudpayment8001.service.GarbageCarService;
import com.mzw.mycommon.entity.CommentResult;
import com.mzw.mycommon.entity.GarbageCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @PACKAGE_NAME: com.mzw.cloudpayment8001.controller
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@RestController
@RefreshScope
public class GarbageCarController {
    @Autowired
    private GarbageCarService garbageCarService;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    @Value("${logger.info}")
    private String loggerInfo;

    @GetMapping("/payment/get/{id}")
    public CommentResult<GarbageCar> getCar(@PathVariable Integer id){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new CommentResult<GarbageCar>(200,"查询成功  ->" + serverPort ,garbageCarService.selectByPrimaryKey(id));
    }

    @GetMapping("/payment/discovery")
    public void getTest(){
        List<String> services = discoveryClient.getServices();
        services.forEach(x-> System.out.println("element " + x));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach((x)->{
            System.out.println(x.getInstanceId() + "\t" + x.getHost() + "\t" + x.getPort() + "\t" + x.getUri());
        });
    }

    @GetMapping("/payment/lb/{id}")
    public CommentResult<String> getCarLb(@PathVariable Integer id){
        return new CommentResult<String>(200,"查询成功  ->" + serverPort ,"test");
    }

    @GetMapping("/logger/info")
    public CommentResult<String> getLoggerInfo(){
        return new CommentResult<String>(200,"查询成功  ->  " + loggerInfo ,"test");
    }
}
