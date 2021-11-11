package com.mzw.netty.nio.netty.rpc.netty;

import com.mzw.netty.nio.netty.rpc.provider.HelloServiceImpl;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.groupchat
 * @AUTHOR: mzw
 * @DATE: 2021/4/9
 */
public class NettyServerHandle extends ChannelInboundHandlerAdapter {

    //客户端发送的字符串需要以#hello#打头
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg.toString().startsWith("#hello#")){
            new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#")+1));

        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }


}
