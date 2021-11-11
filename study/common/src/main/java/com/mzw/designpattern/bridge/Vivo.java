package com.mzw.designpattern.bridge;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.bridge
 * @AUTHOR: mzw
 * @DATE: 2021/5/20
 */
public class Vivo implements Brand {
    @Override
    public void call() {
        System.out.println("Vivo呼叫");
    }

    @Override
    public void open() {
        System.out.println("Vivo开机");
    }
}
