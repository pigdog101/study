package com.mzw.netty.nio.netty.inoroutboundhandle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.simple
 * @AUTHOR: mzw
 * @DATE: 2021/4/2
 */
public class NettyClientHandle extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {

    }
    //创建连接时发送数据
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyClientHandle 发送数据");

        ctx.writeAndFlush(Unpooled.copiedBuffer("abcdabcdefghefgh",CharsetUtil.UTF_8));
    }
}
