package com.mzw.netty.nio.netty.protocoltcp;

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
public class MyMessageToByteEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyMessageToByteEncoder encode 被调用");
        System.out.println("msg " + msg);
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }
}
