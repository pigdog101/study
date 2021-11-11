package com.mzw.netty.nio.netty.rpc.provider;

import com.mzw.netty.nio.netty.rpc.publicinterface.HelloService;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.rpc.provider
 * @AUTHOR: mzw
 * @DATE: 2021/5/4
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String msg) {
        System.out.println("客户端发送的消息为 "+msg);
        return "已收到消息 " + msg;
    }
}
