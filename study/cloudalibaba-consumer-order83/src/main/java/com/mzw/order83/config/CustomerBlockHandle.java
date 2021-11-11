package com.mzw.order83.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mzw.mycommon.entity.CommentResult;
import com.mzw.order83.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME: com.mzw.order83.config
 * @AUTHOR: mzw
 * @DATE: 2021/10/18
 */
public class CustomerBlockHandle{

    public static String handleException1(BlockException blockException){
        return "用户自定义的global_handle----1";
    }

    public static String handleException2(BlockException blockException){
        return "用户自定义的global_handle----2";
    }


}
