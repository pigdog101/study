package com.mzw.java8.interfaceDefault;

/**
 * @PACKAGE_NAME: com.mzw.java8.interfaceDefault
 * @AUTHOR: mzw
 * @DATE: 2021/1/22
 */
public interface DefaultInterface01 {
    default void getName(){
        System.out.println("interface01");
    }
    public static void getAge(){
        System.out.println(1);
    }
}
