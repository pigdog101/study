package com.mzw.netty.nio.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.simple
 * @AUTHOR: mzw
 * @DATE: 2021/4/2
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        //一个事件循环组
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            //创建客户端启动对象bootStrap
            Bootstrap bootstrap = new io.netty.bootstrap.Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientHandle());//加入业务处理器
                        }
                    });
            System.out.println("客户端isOk");
            //启动客户端连接服务端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
