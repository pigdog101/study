package com.mzw.java8;

import com.mzw.java8.lambda.MyFunction;
import com.mzw.java8.service.Mypredate;
import com.mzw.java8.service.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @PACKAGE_NAME: com.mzw.lambda
 * @AUTHOR: mzw
 * @DATE: 2021/1/17
 */
@Slf4j
public class LambdaTest {

    public List<Employee> emplyees = Arrays.asList(
            new Employee(10,"mzw",5555.55),
            new Employee(20,"mzw",6555.55),
            new Employee(30,"mzw",7555.55),
            new Employee(40,"mzw",8555.55),
            new Employee(50,"mzw",9555.55)
    );
    public void test1(){
        List<Employee> list = new ArrayList<>();
        emplyeeFilter((Employee x) -> x.getAge() >=30 ? true : false,list);
        System.out.println(list);
    }
    //策略设计模式
    public void emplyeeFilter(Mypredate<Employee> mypredate, List<Employee> list){
        for (Employee emplyee:emplyees){
            if (mypredate.test(emplyee)){
                list.add(emplyee);
            }
        }
    }
    //lambda 语法1 无参 无返回值
    //lambda 表达式引用外部变量 无法num++， num默认加上final
    public void test2(){
        int num = 0;
//      final int num = 0;
        Runnable runnable = ()-> System.out.println(num +"hello");
        runnable.run();
    }
    //lambda 语法2 有一参 无返回值
    public void test3(){
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("hello");
    }

    //lambda 语法3 有一参 小括号省略
    public void test4(){
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("hello");
    }

    //lambda 语法4 有多参 有返回值
    public void test5(){
        Comparator<Integer> consumer = (x,y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
        log.info("ttttttttttt");
    }

    //lambda 语法5 参数类型可以不写(如果写所有参数都要写)jdk1.8通过上下文推断参数类型"类型推断"
    //左右遇一括号省
    //左侧推断类型省
    //
    public void test6(){
        Comparator<Integer> consumer = (x,y) -> Integer.compare(x,y);
    }
    public void sortEmplyee(){
        Collections.sort(emplyees,(e1,e2)->{
            if (e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Employee emplyee:emplyees){
            System.out.println(emplyee);
        }
        System.out.println(emplyees);
    }
    public void test7(){
        longHandle(((t1, t2) -> t1 * t2),10l,20l);
    }
    public long longHandle(MyFunction<Long,Long> mf,long l1,long l2){
        System.out.println(mf.getValue(l1, l2));
        return 1;
    }

    public static void main(String[] args) {
//        Integer a = 10;
//        if (a!=null)
//            System.out.println(a);
//        System.out.println("t");
        System.out.println("".length());
        String a = "a";
        for (int i = 0; i < 10; i++) {
            a += i;
        }
        System.out.println(a);
    }
}
