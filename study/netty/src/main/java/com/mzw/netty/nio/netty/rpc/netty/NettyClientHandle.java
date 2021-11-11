package com.mzw.netty.nio.netty.rpc.netty;

import com.mzw.netty.nio.netty.protocoltcp.MessageProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.concurrent.Callable;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.simple
 * @AUTHOR: mzw
 * @DATE: 2021/4/2
 */
public class NettyClientHandle extends ChannelInboundHandlerAdapter implements Callable {
    private int count;
    private ChannelHandlerContext context;
    private String result;
    private String param;
    //创建连接时发送数据
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify();
    }
    //被代理对象调用 发送数据给服务器 ， 等待被唤醒
    @Override
    public Object call() throws Exception {
        context.writeAndFlush(param);
        wait();
        System.out.println("call---> result " + result);
        return result;
    }


    public void setParam(String param) {
        this.param = param;
    }
}
