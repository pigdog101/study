package com.mzw.jvm.stack;

/**
 * @PACKAGE_NAME: com.mzw.jvm.stack
 * @AUTHOR: mzw
 * @DATE: 2021/6/29
 */
public class StackErrorTest {
    public static int count = 0;

    public static void main(String[] args) {
        count++;
        System.out.println(count);
        main(args);
    }
}
