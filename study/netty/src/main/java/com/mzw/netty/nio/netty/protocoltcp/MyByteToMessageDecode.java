package com.mzw.netty.nio.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 *
 * 每次读取n个字节 知道无数据可以读取
 * 每次读取都会调用nettyServerHandle
 * 
 *
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.inoroutboundhandle
 * @AUTHOR: mzw
 * @DATE: 2021/4/19
 */
public class MyByteToMessageDecode extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("将数据进行解码");
        //将得到的二进制字节码转化成MessageProto对象
        int len = in.readInt();
        byte[] data = new byte[len];
        in.readBytes(data);
        //放到list传给下一个handle处理数据
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLength(len);
        messageProtocol.setContent(data);
        out.add(messageProtocol);
    }
}
