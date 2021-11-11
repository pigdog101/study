package com.mzw.netty.nio.netty.inoroutboundhandle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 *
 * 当发送的数据不是Long类型是 该编码器不会被调用
 *
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.inoroutboundhandle
 * @AUTHOR: mzw
 * @DATE: 2021/4/19
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("MyLongToByteEncoder encode 被调用");
        System.out.println("msg " + msg);
        out.writeLong(msg);
    }
}
