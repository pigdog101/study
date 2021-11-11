package com.mzw.designpattern.singleton;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.singleton
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public class Singleton02 {
    private Singleton02(){}

    private static class SingletonInstance {
        private static Singleton02 singleton02 = new Singleton02();
    }

    public static Singleton02 getInstance(){
        return SingletonInstance.singleton02;
    }
}
