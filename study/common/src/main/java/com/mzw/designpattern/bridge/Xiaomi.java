package com.mzw.designpattern.bridge;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.bridge
 * @AUTHOR: mzw
 * @DATE: 2021/5/20
 */
public class Xiaomi implements Brand {
    @Override
    public void call() {
        System.out.println("小米手机呼叫");
    }

    @Override
    public void open() {
        System.out.println("小米手机开机");
    }
}
