package com.mzw.netty.nio;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio
 * @AUTHOR: mzw
 * @DATE: 2021/3/5
 */
public class NIOClient {
    public static void main(String[] args) throws Exception{
        //创建一个SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞式
        socketChannel.configureBlocking(false);
        //创建Address
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",8888);
        //如果没有连接完成就一直让程序循环判断是否连接成功若成功则执行下代码
        if (!socketChannel.connect(address)){
            while(!socketChannel.finishConnect()){
                System.out.println("客户端连接需要时间");
            }
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap("hello mzw".getBytes());
        socketChannel.write(byteBuffer);
        System.in.read();
    }
    @Test
    public void client() throws Exception{
        //创建一个SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞式
        socketChannel.configureBlocking(false);
        //创建Address
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",8888);
        //如果没有连接完成就一直让程序循环判断是否连接成功若成功则执行下代码
        if (!socketChannel.connect(address)){
            while(!socketChannel.finishConnect()){
                System.out.println("客户端连接需要时间");
            }
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap("hello mzw".getBytes());
        socketChannel.write(byteBuffer);
        System.in.read();
    }
}
