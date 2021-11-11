package com.mzw.netty.nio.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.simple
 * @AUTHOR: mzw
 * @DATE: 2021/4/1
 */
public class WebSocketNettyServer {
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
                    .handler(new LoggingHandler(LogLevel.INFO))//设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道测试对象
                        //给pipeLine设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //基于http协议使用http编码解码器
                            pipeline.addLast(new HttpServerCodec());
                            //以块的方式写
                            pipeline.addLast(new ChunkedWriteHandler());
                            //http数据传输时分段 当浏览器发送大量数据时会发送多次请求
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            //websocket 数据是以帧(frame)的形式传递的
                            //浏览器发送请求时以websocket协议 ws://localhost:6668/hello
                            //WebSocketServerProtocolHandler 核心功能 将http协议升级为ws协议
                            pipeline.addLast(new WebSocketServerProtocolHandler("/"));

                            //自定义handle处理业务
                            pipeline.addLast(new WebSocketFrameHandle());
                        }
                    });//给workerGroup和bossGroup设置通道处理器
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
