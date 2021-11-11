package com.mzw.netty.nio.netty.protocoltcp;

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
public class NettyClientHandle extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;

    //创建连接时发送数据
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //发送十条数据
        for (int i = 0; i < 10; i++) {
            String msg = "hello server";
            byte[] bytes = msg.getBytes(Charset.forName("utf-8"));
            int len = msg.getBytes(Charset.forName("utf-8")).length;
            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setLength(len);
            messageProtocol.setContent(bytes);
            ctx.writeAndFlush(messageProtocol);
        }
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        System.out.println("客户端接收到的消息量="+ ++count);
    }
}
