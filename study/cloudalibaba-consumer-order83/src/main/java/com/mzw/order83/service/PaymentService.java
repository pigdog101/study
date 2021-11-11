package com.mzw.order83.service;

import com.mzw.mycommon.entity.CommentResult;
import com.mzw.order83.config.CustomerBlockHandle;
import com.mzw.order83.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider-payment",fallback = PaymentServiceImpl.class)
public interface PaymentService {
    @GetMapping("/payment/nacos/{id}")
    public CommentResult<String> getNacos(@PathVariable("id")Long id);
}
