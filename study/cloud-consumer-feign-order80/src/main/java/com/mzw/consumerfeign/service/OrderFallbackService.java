package com.mzw.consumerfeign.service;

import com.mzw.mycommon.entity.CommentResult;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME: com.mzw.consumerfeign.service
 * @AUTHOR: mzw
 * @DATE: 2021/10/1
 */
@Component
public class OrderFallbackService implements GarbageCarService{
    @Override
    public CommentResult<String> hystrixOk(Integer id) {
        return new CommentResult<>(400,"失败","服务异常");
    }

    @Override
    public CommentResult<String> hystrixTimeout(Integer id) {
        return new CommentResult<>(400,"失败","服务异常");
    }
}
