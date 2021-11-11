package com.mzw.netty.nio.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.simple
 * @AUTHOR: mzw
 * @DATE: 2021/4/2
 */
public class NettyServerHandle extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count = 0;
    //读取客户端发送的数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        System.out.println("服务器接收的内容如下");
        System.out.println("len="+msg.getLength());
        String s = new String(msg.getContent(), CharsetUtil.UTF_8);
        System.out.println("content="+s);
        System.out.println("hangdle调用次数="+count);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
