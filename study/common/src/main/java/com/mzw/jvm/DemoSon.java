package com.mzw.jvm;



public class DemoSon extends test2 implements test1{

    public void resolv(){
        System.out.println("x");
    }

    public static void main(String[] args) {
        System.out.println(DemoSon.num1);

//        DemoSon demoSon = new DemoSon();
    }
}

interface test1{
    //静态基本类型常量以字面量形式赋值不会触发初始化 再准备阶段就已显示赋值
    public static int num1 = 1;
    public final static Thread t = new Thread(){
        {
            System.out.println("测试接口");
        }
    };

}

abstract class test2{
    public final static int num2 = 2;

    static {
        System.out.println("测试抽象类");
    }
}