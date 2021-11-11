package com.mzw.netty.nio.netty.rpc.netty;

import com.mzw.netty.nio.netty.protocoltcp.MyClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.rpc.netty
 * @AUTHOR: mzw
 * @DATE: 2021/5/5
 */
public class NettyClient {
    private static ExecutorService executorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static NettyClientHandle handle;
    //编写代理获取代理对象

    private static void init(){
        handle = new NettyClientHandle();


        //一个事件循环组
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            //创建客户端启动对象bootStrap
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new StringEncoder());
                            ch.pipeline().addLast(handle);
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
