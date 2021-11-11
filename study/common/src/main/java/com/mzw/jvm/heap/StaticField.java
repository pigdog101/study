package com.mzw.jvm.heap;

import org.openjdk.jol.vm.VM;

/**
 * @PACKAGE_NAME: com.mzw.jvm.heap
 * @AUTHOR: mzw
 * @DATE: 2021/7/1
 */
public class StaticField {
    public static final byte[] arr = new byte[1024*1024];

    public static void main(String[] args) {

//        test();
//        System.gc();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(VM.current().addressOf(A.class));
//        try {
//            Thread.sleep(100000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
    public static void test(){
//        Class<A> a = A.class;
//        System.out.println(VM.current().addressOf(a));
    }
}
