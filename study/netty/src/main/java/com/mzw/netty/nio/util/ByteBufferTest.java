package com.mzw.netty.nio.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.util
 * @AUTHOR: mzw
 * @DATE: 2021/4/9
 */
public class ByteBufferTest {
    //
    public static void main(String[] args) {
        //buffer 对象包含了arr byte数组 大小是10
        //在netty的buf 不需要使用flip 因为底层维护了 readIndex和writeIndex
        ByteBuf buffer = Unpooled.buffer(10);
        for (int i = 0; i <10 ; i++) {
            buffer.writeByte(i);
        }
        //buffer.capacity() 容量
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.getByte(i));
        }
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.readByte());
        }
        buffer.clear();
    }
    @Test
    public void test01() throws UnsupportedEncodingException {
        //创建buf
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello", CharsetUtil.UTF_8);
        if (byteBuf.hasArray()){
            byte[] array = byteBuf.array();
            //将 array转成字符串
            String s = new String(array, "UTF-8");
            System.out.println(s);
        }
        //可读取的字节数
        byteBuf.readableBytes();
    }
}
