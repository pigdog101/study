package com.mzw.netty.nio.netty.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.inoroutboundhandle
 * @AUTHOR: mzw
 * @DATE: 2021/4/19
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //加入一个handle编码
        ChannelPipeline pipeline = ch.pipeline();
        //再加入一个handle处理逻辑
        pipeline.addLast(new NettyClientHandle());
    }
}
