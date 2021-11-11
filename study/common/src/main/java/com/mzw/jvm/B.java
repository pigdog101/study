package com.mzw.jvm;

import com.mzw.java8.interview.InsideClass;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @PACKAGE_NAME: com.mzw.jvm
 * @AUTHOR: mzw
 * @DATE: 2021/6/23
 */
public class B extends A {
    public int a = 2;
    private final static int b = 22222;
    private static int c = 33333;
//    private static ArithemeticTest arithemeticTest = new ArithemeticTest();
    private int d = 44444;
    private static Integer[] arr = new Integer[1024*1024*380];

    public static void main(String[] args) {
        A a = new B();
        ArrayList<Object> objects = new ArrayList<>();
        objects.contains(a);
    }
}
