package com.mzw.netty.nio.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.simple
 * @AUTHOR: mzw
 * @DATE: 2021/4/2
 */
public class NettyServerHandle extends ChannelInboundHandlerAdapter {
    //读取客户端发送的数据

    /**
     * ChannelHandlerContext ctx：上下文对象 1.含有管道（业务逻辑处理）2.含有通道（数据读写）
     * 3.地址
     * msg：客户端的数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("消息是"+msg);
//        ByteBuf byteBuf = (ByteBuf)msg;
//        System.out.println("客户端发送的数据是"+byteBuf.toString(CharsetUtil.UTF_8));
        //将数据写入到缓存并刷新
        //将耗时的任务提交到taskQueue中异步执行
        ctx.channel().eventLoop().execute(()->{
            try {
                Thread.sleep(10*1000);
                System.out.println(Thread.currentThread().getName());
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端1",CharsetUtil.UTF_8));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            });
        //使用定时任务
        ctx.channel().eventLoop().schedule(()->{
            try {
                Thread.sleep(10*1000);
                System.out.println(Thread.currentThread().getName());
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端2",CharsetUtil.UTF_8));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },5, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName());
        System.out.println("go on ... ");
    }
    //读取数据完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将数据写入到缓存并刷新
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端2",CharsetUtil.UTF_8));
    }
    //处理异常 关闭通道

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
