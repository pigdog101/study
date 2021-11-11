package com.mzw.order83.Controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mzw.mycommon.entity.CommentResult;
import com.mzw.mycommon.entity.GarbageCar;
import com.mzw.order83.config.CustomerBlockHandle;
import com.mzw.order83.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @PACKAGE_NAME: com.mzw.cloudorder80.Controller
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@RestController
public class OrderController {
//    private final static String url = "http://localhost:8001";
    @Value("${service-url.nacos-provider-service}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/nacos/{id}")
    @SentinelResource(value = "fallback",fallback = "handleFallback",
                    blockHandler = "handleException2")
    public CommentResult<GarbageCar> getCar(@PathVariable Integer id){
        CommentResult forObject = restTemplate.getForObject(url + "/payment/nacos/" + id, CommentResult.class, 5);
        if (id.intValue()==4){
            throw new RuntimeException("不存在");
        }
        return forObject;
    }
    //fallback示例
    public CommentResult<String> handleFallback(@PathVariable Integer id,Throwable throwable){
        CommentResult<String> result = new CommentResult<>(444, "fallback演示", null);
        return result;
    }

    public static String handleException2(BlockException blockException){
        return "用户自定义的global_handle----2";
    }


    @GetMapping("/payment/sentinelA/{id}")
    public String getSentinel(@PathVariable Integer id){

        return Thread.currentThread().getId()  + "-> sentinel";
    }

    @GetMapping("/payment/sentinelB/{id}")
    public String getSentinel1(@PathVariable Integer id){
        System.out.println(Thread.currentThread().getId()  + "-> sentinelB");
        return Thread.currentThread().getId()  + "-> sentinelB";
    }

    @GetMapping("/payment/sentinelD")
    public String getSentinel1(){
        //测试平均响应时间
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //测试异常比例
        int a = 10/0;
        System.out.println(Thread.currentThread().getId()  + "-> sentinelD");
        return Thread.currentThread().getId()  + "-> sentinelD";
    }

    @GetMapping("/payment/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        System.out.println(Thread.currentThread().getId()  + "-> testHotKey");
        return Thread.currentThread().getId()  + "-> testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException blockException){
        return "deal_testHotKey";
    }

    @GetMapping("/customerBlockHandle")
    @SentinelResource(value = "customerBlockHandle",
            blockHandlerClass = CustomerBlockHandle.class,
            blockHandler = "handleException2")
    public String customerBlockHandle(){
        return Thread.currentThread().getId()  + "-> customerBlockHandle";
    }

    //=================feign======================
    @GetMapping("/consumer/nacos/{id}")
    public CommentResult<String> getNacos(@PathVariable("id")Long id){
        return paymentService.getNacos(id);
    }
}
