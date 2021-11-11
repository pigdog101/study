package com.mzw.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PACKAGE_NAME: com.mzw.netty.bio
 * @AUTHOR: mzw
 * @DATE: 2021/1/26
 */
public class BioSocket {

    public static void main(String[] args) throws IOException {
        //创建服务端
        ServerSocket serverSocket = new ServerSocket(6666);
        //创建一个最大线程数和核心线程数相同的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true){
            //不停的接手请求并创建任务提交到线程池中
            System.out.println("等待连接---阻塞");
            Socket socket = serverSocket.accept();
            System.out.println("通信成功");
            executorService.execute(()-> handle(socket));

        }
    }

    public static void handle(Socket socket){
        InputStream inputStream = null;
        System.out.println("输出线程号-------------"+Thread.currentThread().getId());
        try {
            inputStream = socket.getInputStream();
            byte[] data = new byte[1024];
            //read方法也会阻塞没有数据 while就会阻塞在这
            while (inputStream.read(data)!=-1){
                System.out.println("接收的数据为" + new String(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
