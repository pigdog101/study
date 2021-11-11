package com.mzw.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio
 * @AUTHOR: mzw
 * @DATE: 2021/3/4
 */
public class NIOServer {
    public static void main(String[] args) throws Exception{
        //创建一个ServerSocketChannel服务端
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //创建一个Selector
        Selector selector = Selector.open();
        //服务端bind端口8888
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        //服务端设置非阻塞式
        serverSocketChannel.configureBlocking(false);

        //把服务端注册到selector中 设置关心的事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //循环等待客户端连接
        while (true){
            //没有事件发生则继续
            if (selector.select(1000)==0){
                System.out.println("没有事件发生");
                continue;
            }
            //有事件发生则获取selectorKey
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
            //遍历selectionKey
            while(selectionKeyIterator.hasNext()){
                //如果是客户端的连接则创建socketChannel与客户端会话
                SelectionKey selectionKey = selectionKeyIterator.next();
                if (selectionKey.isAcceptable()){
                    //accept本身是阻塞方法 但是当前情况下已经得知有客户端连接了 所以体现的是非阻塞的特性
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("客户端连接成功 hash="+socketChannel.hashCode());
                    //将socketchannel注册到selector中
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                //如果发生客户端通过socketChannel发送数据 即OP_READ
                if (selectionKey.isReadable()){
                    //通过selection的channel方法向下转型获得socketChannel
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    //获取byteBuffer
                    ByteBuffer buffer = (ByteBuffer)selectionKey.attachment();
                    channel.read(buffer);
                    System.out.println("客户端发送数据为"+new String(buffer.array()));
                }
                //移除处理完了的selectionKeyIterator
                selectionKeyIterator.remove();
            }
        }
    }
}
