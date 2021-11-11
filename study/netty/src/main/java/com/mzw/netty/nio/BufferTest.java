package com.mzw.netty.nio;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio
 * @AUTHOR: mzw
 * @DATE: 2021/1/26
 */
public class BufferTest {

    public static void main(String[] args) {
        //创建一个容量为5的buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //往buffer里存数据
        for (int i = 0; i <intBuffer.capacity() ; i++) {
            intBuffer.put(i*2);
        }
        //切换读取模式
        intBuffer.flip();
        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }

    @Test
    public void bufferTest(){
        Channel channel;
    }

    //MappedByteBuffer可以让文件直接在堆外内存中修改，操作系统不需要拷贝一次
    @Test
    public void MappedByteBufferTest() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("nio1.txt","rw");

        FileChannel channel = accessFile.getChannel();
        /**
         * 参数一 模式
         * 参数二 起始位置和可操作的字节数
         */
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put((byte) 'y');
        map.put((byte) 'y');
        channel.close();
    }
}
