package com.mzw.designpattern.singleton;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.singleton
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public enum  SingletonEnum {
    INSTANCE;
    public void sayOk(){
        System.out.println("ok");
    }

    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        System.out.println(instance==instance2);
    }
}
