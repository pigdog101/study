package com.mzw.netty.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.groupchat
 * @AUTHOR: mzw
 * @DATE: 2021/3/8
 */
public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel listenSocket;
    private final Integer PORT = 6667;

    public GroupChatServer(){
        try {
            selector = Selector.open();
            listenSocket = ServerSocketChannel.open();
            listenSocket.configureBlocking(false);
            listenSocket.socket().bind(new InetSocketAddress(PORT));
            listenSocket.register(selector, SelectionKey.OP_ACCEPT);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void listen(){
        try{
            while(true){
                int count = selector.select();
                if(count>0){
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while(iterator.hasNext()){
                        SelectionKey selectionKey = iterator.next();
                        if(selectionKey.isAcceptable()){
                            SocketChannel sc = listenSocket.accept();
                            sc.configureBlocking(false);
                            sc.register(selector,SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress() + " 客户已上线");
                        }
                        if (selectionKey.isReadable()){
                            read(selectionKey);
                        }
                        //操作完之后删掉该selectionKey
                        iterator.remove();
                    }
                }else{
                    System.out.println("等待连接");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }

    public void read(SelectionKey key){
        SocketChannel channel = null;
        try{
            channel = (SocketChannel) key.channel();
            //读取客户端发送的数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);
            System.out.println(channel.getRemoteAddress() + "发送的数据为" + new String(buffer.array()));
            //发送数据到其他的客户端
            sendInfoToOthers(channel.getRemoteAddress()+":"+new String(buffer.array()),channel);

        }catch (IOException e){
            try{
                System.out.println(channel.getRemoteAddress()+" 用户离线了");
                //key取消注册
                key.cancel();
                //关闭通道
                channel.close();
            }catch (IOException e2){
                e.printStackTrace();
            }
        }
    }

    public void sendInfoToOthers(String msg,SocketChannel self) throws IOException{
        System.out.println("服务端转发消息");
        Set<SelectionKey> selectionKeys = selector.keys();
        for (SelectionKey key: selectionKeys){
            //通过selection的channel方法向下转型获得socketChannel
            Channel channel = key.channel();
            //这里的key有可能是Accept或者是read 要么是ServerSocketChannel要么是Socketchannl要区分开
            if(channel instanceof SocketChannel && channel != self){
                SocketChannel dest = (SocketChannel) channel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                dest.write(buffer);
            }
        }
    }

    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}
