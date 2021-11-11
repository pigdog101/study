package com.mzw.java8.interview;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/10
 */
public class CASTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t" + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }

    @Test
    public void atomicReferenceTest(){
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User zs = new User("zs", 1);
        User lis = new User("lis", 2);
        atomicReference.set(zs);
        System.out.println(atomicReference.compareAndSet(zs,lis) + atomicReference.get().toString());

        System.out.println(atomicReference.compareAndSet(zs,lis) + atomicReference.get().toString());

    }

    @Test
    public void test01(){
        int i = 0;
        int a = i++;
        System.out.println(a);
        System.out.println(i);
        int j = 0;
        int b = ++j;
    }

    public void test02(){
        int i = 0;
        i++;

        int j = 0;
        ++j;
    }
}

class User{
    String name;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getAge();
    }
}