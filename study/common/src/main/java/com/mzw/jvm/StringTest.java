package com.mzw.jvm;

public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("hello")+new String("world");
        String s = "helloworld";
        System.out.println(s == s1);
    }
}
