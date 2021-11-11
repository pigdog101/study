package com.mzw.netty.nio.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.groupchat
 * @AUTHOR: mzw
 * @DATE: 2021/4/9
 */
public class GroupchatServerHandle extends SimpleChannelInboundHandler<String> {
    //定义一个channel组管理所有的channel
    //GlobalEventExecutor.INSTANCE 全局事件执行器 单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //handlerAdded 表示当连接建立时执行
    //将当前channel 加入到channelgroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //将该用户加入聊天室的消息传达给其他客户端
        //该方法会遍历所有channel并发送消息
        channelGroup.writeAndFlush("[客户端]"+ctx.channel().remoteAddress()+"加入聊天");
        channelGroup.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush("[客户端]"+ctx.channel().remoteAddress()+"离开聊天");
        System.out.println("channelGroup size"+channelGroup.size());
    }

    //连接状态
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+" 已上线");
    }
    //断开连接
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+" 已离线");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        Channel channel = channelHandlerContext.channel();
        channelGroup.forEach((ch)->{
            //客户的通道
            if (ch!=channel){
                ch.writeAndFlush("[客户]"+ch.remoteAddress()+"发送了消息"+s+"\n");
            }else {//自己的通道
                ch.writeAndFlush("[自己]"+"发送了消息"+s+"\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    public static void main(String[] args) {
    }
}
