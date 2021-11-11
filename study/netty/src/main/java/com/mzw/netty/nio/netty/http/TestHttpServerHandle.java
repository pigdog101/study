package com.mzw.netty.nio.netty.http;

import com.mzw.netty.nio.netty.simple.NettyServerHandle;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.nio.Buffer;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.http
 * @AUTHOR: mzw
 * @DATE: 2021/4/7
 * HttpObject 客户端和服务端相互通讯的数据被封装成HttpObject
 */
public class TestHttpServerHandle extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        if (httpObject instanceof HttpRequest){
            System.out.println("msg 类型"+httpObject.getClass());
            System.out.println("客户端地址"+channelHandlerContext.channel().remoteAddress());
            //回复消息给客户端【http协议】
            ByteBuf buf = Unpooled.copiedBuffer("hello 我是服务器", CharsetUtil.UTF_8);
            //构建一个httpResponse
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,buf.readableBytes());
            channelHandlerContext.writeAndFlush(response);
        }
    }
}
