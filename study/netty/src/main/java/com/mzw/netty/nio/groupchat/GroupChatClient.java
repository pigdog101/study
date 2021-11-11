package com.mzw.netty.nio.groupchat;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.groupchat
 * @AUTHOR: mzw
 * @DATE: 2021/3/25
 */
public class GroupChatClient {
    private final String HOST = "127.0.0.1";
    private final Integer PORT = 8880;
    private Selector selector;
    private SocketChannel socketChannel;

    public GroupChatClient() throws Exception{
        selector = Selector.open();
        socketChannel = SocketChannel.open();
        if (!socketChannel.connect(new InetSocketAddress(HOST,PORT))){
            while(!socketChannel.finishConnect()){
                System.out.println("客户端连接需要时间");
            }
        }
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public void sendInfo(String info){
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readInfo(){
        try {
            int count = selector.select();
            if (count>0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> key = selectionKeys.iterator();
                while(key.hasNext()){
                    SelectionKey selectionKey = key.next();
                    if (selectionKey.isReadable()){
                        SocketChannel channel = (SocketChannel)selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int read = channel.read(byteBuffer);
                        String msg = new String(byteBuffer.array());
                        System.out.println(msg);
                    }
                    key.remove();
                }
            }else {
                //System.out.println("没有监听到事件");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        GroupChatClient groupChatClient = new GroupChatClient();
        executorService.execute(()->{
            while(true){
                groupChatClient.readInfo();
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            groupChatClient.sendInfo(scanner.next());
        }
    }
    @Test
    public void client1() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        GroupChatClient groupChatClient = new GroupChatClient();
        executorService.execute(()->{
            while(true){
                groupChatClient.readInfo();
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            groupChatClient.sendInfo(scanner.next());
        }
    }
}
