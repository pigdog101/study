package com.mzw.netty.nio.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.groupchat
 * @AUTHOR: mzw
 * @DATE: 2021/4/9
 */
public class WebSocketFrameHandle extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    //定义一个channel组管理所有的channel
    //GlobalEventExecutor.INSTANCE 全局事件执行器 单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //handlerAdded 表示当连接建立时执行
    //将当前channel 加入到channelgroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded调用" + ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved调用" + ctx.channel().id().asLongText());

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    public static void main(String[] args) {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        System.out.println("服务器收到消息 "+textWebSocketFrame.text());
        channelHandlerContext.writeAndFlush(new TextWebSocketFrame("服务器时间"+ new Date()+" " + textWebSocketFrame.text()));

    }
}
