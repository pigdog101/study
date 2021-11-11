package com.mzw.netty.nio.netty.inoroutboundhandle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

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
public class MyByteToLongDecode extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("将数据进行解码");
        if (in.readableBytes()>=8){
            out.add(in.readLong());
        }
    }
}
