package com.mzw.order83.service.impl;

import com.mzw.mycommon.entity.CommentResult;
import com.mzw.order83.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl  implements PaymentService {
    @Override
    public CommentResult<String> getNacos(Long id) {
        return new CommentResult<>(444,"错误返回","");
    }
}
