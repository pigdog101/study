package com.mzw.netty.nio.netty.inoroutboundhandle;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.simple
 * @AUTHOR: mzw
 * @DATE: 2021/4/1
 */
public class NettyServer {
    public static void main(String[] args) throws Exception {

        //1.创建workerGroup和bossGroup
        //boosGroup处理连接请求而worker处理客户端的数据读取
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //不指定默认是cpu核数*2 =  本服务器16
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //创建服务端启动对象
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)//使用NioSocketChannel作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持活动连接状态
                    .childHandler(new MyServerInitializer());//给workerGroup和bossGroup设置通道处理器
            //服务端绑定端口并启动
            ChannelFuture channelFuture = serverBootstrap.bind(6668).sync();
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}
