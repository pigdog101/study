package com.mzw.netty.nio;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio
 * @AUTHOR: mzw
 * @DATE: 2021/1/27
 */
public class ChannelTest {

    @Test
    public void test1() throws IOException {
        //数据源src
        String src = "hw,nio";
        //通过FileOutputStream获取FileChannelImpl
        FileOutputStream fos = new FileOutputStream("d:/nio.txt");
        FileChannel fileChannel = fos.getChannel();
        //创建一个capacity为1024的buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //往bytebuffer里存数据
        buffer.put(src.getBytes());
        //把buffer改成读模式
        buffer.flip();
        //往fileChannel里写数据
        fileChannel.write(buffer);
        fos.close();
    }

    @Test
    public void test2() throws IOException {
        //创建输入流获取源文件数据
        File file = new File("d:/nio.txt");
        FileInputStream fis = new FileInputStream(file);
        //通过流获取通道
        FileChannel fileChannel = fis.getChannel();
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
        //主程序从channel里read数据，即channel往buffer里写入数据
        fileChannel.read(buffer);
        byte[] data = buffer.array();
        System.out.println(new String(data));
        fis.close();
    }

    @Test
    public void test3() throws IOException {
        FileInputStream fis = new FileInputStream("nio1.txt");
        FileChannel fileChannel01 = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("nio2.txt");
        FileChannel fileChannel02 = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);
        while(fileChannel01.read(buffer)!=-1){
//            buffer.clear();
            buffer.flip();
            fileChannel02.write(buffer);
            buffer.clear();
        }
        fis.close();
        fos.close();
    }
}
