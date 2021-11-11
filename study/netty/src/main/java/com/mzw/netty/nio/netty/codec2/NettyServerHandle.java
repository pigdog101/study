package com.mzw.netty.nio.netty.codec2;

import com.mzw.netty.nio.netty.codec.studentPOJO;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

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
        //读取从客户端发送的studentPojo
        DataInfo.MyMessage message = (DataInfo.MyMessage)msg;
        if (message.getDataType().toString().equals(DataInfo.MyMessage.DataType.StudentType.toString())){
            DataInfo.Student student = message.getStudent();
            System.out.println(student.getId()+"---"+student.getName());
        }else {
            DataInfo.Worker worker = message.getWorker();
            System.out.println(worker.getId()+"---"+worker.getName());
        }
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
