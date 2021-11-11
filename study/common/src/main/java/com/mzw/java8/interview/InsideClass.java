package com.mzw.java8.interview;

import java.util.ArrayList;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/9/7
 */
public class InsideClass {
    private String outSideName = "";
    private static String staticOutSideName = "";
    static {
        System.out.println("InsideClass -------- init");
    }
    class Test1{
//        private static int i = 0;
        //3.非静态内部类不能有静态代码块 因为非静态内部类不能主动加载，只能等外部类实例化之后才有机会
//        static {
//            System.out.println("Test2 -------- init");
//        }
        //2.非静态内部类可以获取外部类的成员变量 静态内部类 可以获取外部类的成员变量
        private String name = outSideName;

    }

    static class Test2{
        //2.非静态内部类可以获取外部类的成员变量 静态内部类 可以获取外部类的成员变量
        private String name = staticOutSideName;
        //4.类加载的时机不同，外部类加载时内部类不会加载，内部类只有在被调用时才会加载
        static {
            System.out.println("Test2 -------- init");
        }
    }

    public void say(){
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        new ArrayList<>().stream();
        InsideClass.Test2 test21 = new Test2();
    }

    public static void main(String[] args) {
//        Test2 test2 = new Test2();

    }
}

class OutSideClass{
    public void say(){
        InsideClass insideClass = new InsideClass();
        InsideClass.Test1 test1 = insideClass.new Test1();
        InsideClass.Test2 test2 = new InsideClass.Test2();
    }

    public static void main(String[] args) {
        InsideClass insideClass = new InsideClass();
        //1.静态内部类和非静态内部类实例化方式不同
        InsideClass.Test1 test1 = insideClass.new Test1();
        InsideClass.Test2 test2 = new InsideClass.Test2();
    }
}