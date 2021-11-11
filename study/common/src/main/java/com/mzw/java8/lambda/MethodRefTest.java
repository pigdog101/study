package com.mzw.java8.lambda;

import com.mzw.java8.service.entity.Employee;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @PACKAGE_NAME: com.mzw.java8.lambda
 * @AUTHOR: mzw
 * @DATE: 2021/1/19
 * 方法引用：若lambda体中有方法A实现了，我们可以使用"方法引用"，注意函数式接口返回值必须与A的
 * 返回值一致,参数列表也必须一致
 * （可以理解为lambda表达式的另一种形式）
 *
 * 三种语法格式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 *
 *
 * 构造器引用 构造器的参数列表、返回值类型 与 函数式式接口一致
 * ClassName ::new
 */
public class MethodRefTest {

    //对象::实例方法名
    @Test
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> con = (x)-> ps.println(x);
        PrintStream ps1 = System.out;
        Consumer<String> con1 = ps1::println;
        Consumer<String> con2 = System.out::println;
        con2.accept("test");

        final Employee emp = new Employee();
        Supplier<String> sup = ()-> emp.getName();

        Supplier<String> sup1 = emp::getName;
        System.out.println(sup1.get());

    }
    //类::静态方法名
    @Test
    public void test2(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        Comparator<Integer> com1 = Integer::compare;
    }

    //类::实例方法名

    @Test
    public void test3(){
        BiPredicate<String,String> bp = (x,y)-> x.equals(y);
        //当lambda第一个参数是实例方法的调用者，第二个参数是实例方法参数时
        BiPredicate<String,String> bp1 = String::equals;
    }

    //构造器应用
    public void test4(){
        Supplier<Employee> sup = ()-> new Employee();

        Supplier<Employee> sup1 = Employee::new;

        Function<Integer,Employee> bf1 = Employee::new;

        BiFunction<Integer,String,Employee> bf = Employee::new;
    }

}
