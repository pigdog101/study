package com.mzw.jvm;

public class SonTest {

    public static void main(String[] args) {
        Father son = new Son();
        System.out.println(son.y);

    }
}

class Father{

    int y = 100;
    int x = 10;
    public void testStatic(){
        System.out.println("say father");
    }
    public Father(){
        this.print();
        x = 20;
    }
    public void print(){
        System.out.println("Father.x=" + x);
    }
}
//子类在初始化之前会先初始化父类，并执行父类的init构造方法，由于子类重写了print所以由子类执行print
//但是由于子类还没有初始化 所以执行重写的父类的print方法的时候输出的是int类型的默认值0
class Son extends Father{
    int x = 30;
    int y = 10;
    public Son(){
        this.print();
        x = 40;
    }
    public void testStatic(){
        System.out.println("say son");
    }
    public static void main(String[] args) {
        Father son = new Son();
        System.out.println(son.x);
    }
    @Override
    public void print() {
        System.out.println("Son.x = " + x);
    }
}