package com.mzw.netty.nio.netty.protocoltcp;

/**
 * @PACKAGE_NAME: com.mzw.netty.nio.netty.protocoltcp
 * @AUTHOR: mzw
 * @DATE: 2021/4/21
 */
//协议包
public class MessageProtocol {
    private int length;
    private byte[] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public MessageProtocol() {
    }

    public MessageProtocol(int length, byte[] content) {
        this.length = length;
        this.content = content;
    }
}
