package com.mzw.netty.nio.netty.tcp;

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
public class NettyServerHandle extends SimpleChannelInboundHandler<ByteBuf> {
    private int count = 0;
    //读取客户端发送的数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] data = new byte[msg.readableBytes()];
        msg.readBytes(data);
        System.out.println("服务器接收到的消息为 "+new String(data, Charset.forName("utf-8")));
        System.out.println("服务器接收到的消息量="+ ++count);
        //服务器回送随机的uuid给客户端
        ByteBuf byteBuf = Unpooled.copiedBuffer(UUID.randomUUID().toString(), Charset.forName("utf-8"));
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
