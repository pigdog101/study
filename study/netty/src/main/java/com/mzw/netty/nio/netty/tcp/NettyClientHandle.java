package com.mzw.netty.nio.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.simple
 * @AUTHOR: mzw
 * @DATE: 2021/4/2
 */
public class NettyClientHandle extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;

    //创建连接时发送数据
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello server" + i, CharsetUtil.UTF_8);
            ctx.writeAndFlush(byteBuf);
        }
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] data = new byte[msg.readableBytes()];
        msg.readBytes(data);
        System.out.println("客户端接收到的消息为 "+new String(data, Charset.forName("utf-8")));
        System.out.println("客户端接收到的消息量="+ ++count);
    }
}
