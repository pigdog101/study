package com.mzw.jvm;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Random;

/**
 * @PACKAGE_NAME: com.mzw.jvm
 * @AUTHOR: mzw
 * @DATE: 2021/1/14
 *
 * 类的主动使用 意味着调用<clinit>方法
 *
 * 1.当创建一个类的实例时，new关键字，克隆、反射、反序列化。
 * 2.当调用类的静态方法时，即当使用了字节码指令invokestatic时。
 * 3.当使用类、接口的静态字段时（final修饰特殊考虑），使用getstatic、putstatic（访问、赋值）
 * 4.当使用 java.lang.reflect 包下的方法反射类的方法时，如Class.forName();
 * 5.初始化子类时若父类还没有被初始化，则初始化父类。
 * 6.如果一个接口定义了default方法、那么直接或者间接实现了这个接口的类初始化时要先初始化 接口
 * 7.当虚拟机启动时，用户需要指定一个main方法所在的类，虚拟机会先初始化这个主类
 * 8.当初次调用 MethodHandle实例时 ，初始化MethodHandle指向方法所在的类
 *
 *
 * 针对5 补充说明
 * 虚拟机初始化一个类时 必须先初始化其父类 ，但不包括接口
 * 在初始化一个接口时不会初始化其父接口
 * 因此一个父接口不会因为其子接口或实现类的初始化而初始化，只有程序首次使用该接口的静态字段时才会初始化
 */
public class ActiveUser1 {
    //对象的序列化
    @Test
    public void test1() throws FileNotFoundException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            oos.writeObject(new Order());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (oos!=null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //对象的反序列化
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            Order order = (Order) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ois!=null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testInteface(){
        System.out.println(Inteface2.id);
    }
}

class Order implements Serializable {

    static {
        System.out.println("Order类的初始化过程");
    }
}

interface Inteface1{
    public static final Thread t = new Thread(){
        {
            System.out.println("Inteface1初始化");
        }
    };
}

interface Inteface2 extends Inteface1{
    int id = 1 ;
    public static final Thread t = new Thread(){
        {
            System.out.println("Inteface2初始化");
        }
    };
    public static final int num = new Integer(10);
}