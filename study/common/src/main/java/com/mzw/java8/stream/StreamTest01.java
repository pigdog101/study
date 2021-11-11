package com.mzw.java8.stream;

import com.mzw.java8.service.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @PACKAGE_NAME: com.mzw.java8.stream
 * @AUTHOR: mzw
 * @DATE: 2021/1/19
 *
 * stream流程
 *
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 */
public class StreamTest01 {

    public List<Employee> emplyees = Arrays.asList(
            new Employee(10,"mzw",5555.55),
            new Employee(20,"mzw",6555.55),
            new Employee(30,"mzw",7555.55),
            new Employee(40,"mzw",8555.55),
            new Employee(50,"mzw",9555.55),
            new Employee(50,"mzw",9555.55),
            new Employee(50,"mzw",9555.55)
    );

    //1.创建stream
    @Test
    public void test01(){
        //1.可以同坐Collection的stream() 方法 或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays.stream()方法获取流
        Employee[] emps = new Employee[10];
        Stream<Employee> empsStream = Arrays.stream(emps);

        //3.通过Stream类中的静态方法of()获取流
        Stream<Integer> integerStream = Stream.of(1,3,2);

        //4.创建无线流
        // 通过迭代
        Stream<Integer> iterateStream = Stream.iterate(0,(x)->x+2);
        iterateStream.limit(10).forEach(System.out::println);

        //通过生成
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);

    }

    @Test
    public void test02(){
        List<Integer> collect = emplyees.stream().map(x -> x.getAge()).collect(Collectors.toList());
        System.out.println(collect);
    }

    //2.中间操作

    //1.筛选和切片
    /**
     * 1.filter过滤满足条件的
     * 2.limit获取截止前n个元素
     * 3.skip 跳过前n个元素
     * 4.distinct 筛选，通过流生成元素的hashcode和equals去除重复元素
     */
    @Test
    public void test2(){
        //1.中间操作 (惰性求职)延迟操作：中间操作不会进行任何处理
        // 只有当执行终止操作时中间操作一次性执行
        Stream<Employee> employeeStream = emplyees.stream().filter((e)->{
            System.out.println(e.getAge());
            return e.getAge()>10;
        })
        //limit(n)会进行短路操作找到符合条件的n条数据之后就不会再继续遍历
        .limit(10).distinct();
        //终止操作
        employeeStream.forEach(System.out::println);
    }

    /**
     * 2.映射
     * map-接收lambda 将元素转化为其他形式或提取信息。
     * 接收一个函数作为参数，该函数会应用到每一个元素上，并将其映射成一个新元素
     * flatMap-接收一个函数作为一个参数将流中的每个值转换成另一个流，然后把所有流连接成一个流
     *
     * map和flatMap的区别 类似add和addAll的区别
     *
     */

    @Test
    public void test3(){
        //map
        List<String> strs = Arrays.asList("aaa","bbb","ccc","ddd");
//        strs.stream().map((x)-> x.toUpperCase()).forEach(System.out::println);
//        emplyees.stream().map((x)->x.getSalary()).forEach(System.out::println);
//
        //flatMap
        StreamTest01 st = new StreamTest01();
        //流的集合
//        Stream<Stream<Character>> ssc =  strs.stream().map(st::getStream);
//        ssc.forEach((x)->{
//            x.forEach(System.out::println);
//        });
        //流元素的集合 相当于一个新流
        strs.stream().flatMap(st::getStream).forEach(System.out::println);
    }

    public Stream<Character> getStream(String str){
        List<Character> list = new ArrayList<>();
        for (Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    //add 和addAll区别演示
    @Test
    public void testAddAndAddAll(){
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list1.add(11);
        list1.add(22);
        list2.add(33);
        list2.addAll(list1);
        System.out.println(list2);
    }

    /**
     * 3.排序
     * sorted()-自然排序 (排序对象实现Comparable接口)
     * sorted(Comparator com)-定制排序(方法传递Comparator 接口的实现类)
     */
    @Test
    public void test4(){
        List<String> strs = Arrays.asList("aaa","bbb","ccc","ddd");
        //自然排序
        strs.stream().sorted().forEach(System.out::println);
        //定制排序
        emplyees.stream().sorted((x,y)->{
            if (x.getAge().intValue()==y.getAge().intValue()){
                return x.getName().compareTo(y.getName());
            }else{
                return Integer.compare(x.getAge(),y.getAge());
            }
        }).forEach(System.out::println);
    }
}
