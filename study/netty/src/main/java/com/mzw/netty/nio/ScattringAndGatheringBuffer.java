package com.mzw.netty.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio
 * @AUTHOR: mzw
 * @DATE: 2021/1/28
 */
public class ScattringAndGatheringBuffer {

    @Test
    public void test1() throws IOException {
        //创建一个ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //bind 一下端口
        InetSocketAddress socketAddress = new InetSocketAddress(8000);
        serverSocketChannel.bind(socketAddress);
        //创建一个buffer
        ByteBuffer[] buffers = new ByteBuffer[2];
        buffers[0] = ByteBuffer.allocate(5);
        buffers[1] = ByteBuffer.allocate(3);
        SocketChannel socketChannel = serverSocketChannel.accept();
        int byteSize = 8;
        while(true){
            //scatting
            int byteRead = 0;
            while(byteRead<byteSize){
                long read = socketChannel.read(buffers);
                byteRead+=read;
                Arrays.asList(buffers).forEach((x)->
                        System.out.println("limit:" + x.limit()+"---"+"position"+x.position()));
                System.out.println("byteRead:=" + byteRead);
            }

            //遍历buffers逐个flip()
            Arrays.asList(buffers).forEach((x)->x.flip());
            //gathering
            int byteWrite = 0;
            while(byteWrite<byteSize){
                long write = socketChannel.write(buffers);
                byteWrite += write;
                Arrays.asList(buffers).forEach(x->System.out.println("limit:" + x.limit()+"---"+"position"+x.position()));
                System.out.println("byteWrite:=" + byteWrite);
            }
            Arrays.asList(buffers).forEach((x)->x.clear());
        }
    }
}
