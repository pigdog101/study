package com.mzw.consumerfeign.service;

import com.mzw.mycommon.entity.CommentResult;
import com.mzw.mycommon.entity.GarbageCar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @PACKAGE_NAME: com.mzw.consumerfeign.service
 * @AUTHOR: mzw
 * @DATE: 2021/9/27
 */
@Component
@FeignClient(value = "cloud-hystrix-payment",fallback = OrderFallbackService.class)
public interface GarbageCarService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public CommentResult<String> hystrixOk(@PathVariable Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public CommentResult<String> hystrixTimeout(@PathVariable Integer id);
}
