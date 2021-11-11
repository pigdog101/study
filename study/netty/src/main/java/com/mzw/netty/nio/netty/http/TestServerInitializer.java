package com.mzw.netty.nio.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.http
 * @AUTHOR: mzw
 * @DATE: 2021/4/7
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.out.println("打印一下socketchannel的hash"+socketChannel.hashCode());
        //nioSocketChannel.eventLoop().execute();
        //是由netty提供的http编解码器
        socketChannel.pipeline().addLast("MyCodec",new HttpServerCodec());
        //添加自定义的handle
        socketChannel.pipeline().addLast("MyHandle",new TestHttpServerHandle());
    }
}
