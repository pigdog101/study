package com.mzw.netty.nio.netty.groupchat;

import com.mzw.netty.nio.netty.simple.NettyClientHandle;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.groupchat
 * @AUTHOR: mzw
 * @DATE: 2021/4/13
 */
public class GroupChatClient {
    private int port;
    private String host;

    public GroupChatClient(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public void run(){
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
                            System.out.println("打印一下socketchannel的hash"+socketChannel.hashCode());
                            //nioSocketChannel.eventLoop().execute();
                            socketChannel.pipeline().addLast("decoder",new StringDecoder());
                            socketChannel.pipeline().addLast("encoder",new StringEncoder());
                            socketChannel.pipeline().addLast(new NettyClientHandle());//加入业务处理器
                        }
                    });
            System.out.println("客户端isOk");
            //启动客户端连接服务端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();
            Channel channel = channelFuture.channel();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                channel.writeAndFlush(s+"\r\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
