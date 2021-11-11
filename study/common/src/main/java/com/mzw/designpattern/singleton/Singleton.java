package com.mzw.designpattern.singleton;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.singleton
 * @AUTHOR: mzw
 * @DATE: 2021/5/13
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton(){

    }
    public static Singleton getInstence(){
        if (singleton !=null){
            return singleton;
        }
        synchronized (Singleton.class){
            if (singleton ==null){
                singleton = new Singleton();
            }
            return singleton;
        }
    }
}
