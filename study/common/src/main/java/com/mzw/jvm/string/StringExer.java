package com.mzw.jvm.string;

import com.mzw.jvm.JavapTest;
import org.junit.jupiter.api.Test;

/**
 * @PACKAGE_NAME: com.mzw.jvm.string
 * @AUTHOR: mzw
 * @DATE: 2021/7/7
 */
public class StringExer {
    public String str = "good";
    public String str1 = "good";
    public char[] ch = {'t','e'};

    public void change(String str,char[] ch){
        //这里的str存在于栈帧中的局部变量表中 原来指向stringTable中的"good"后指向"bad"
        str = "bad";
        //ch也存在于栈帧中的局部变量表中都指向堆空间中的ch 由于字符数组可变 所以可以直接修改其内存中的内容
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringExer se = new StringExer();
        se.change(se.str,se.ch);
        System.out.println(se.str);
        System.out.println(se.ch);
    }
    @Test
    public void test1(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }

    /**
     * 字符串拼接不一定是stringBuild如果都是字符串常量的应用 则仍然使用编译期优化
     */
    @Test
    public void test2(){
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }

    /**
     * stringBuild与字符串拼接效率对比
     */
    @Test
    public void test3(){
        long start = System.currentTimeMillis();
        method2(100000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public void method1(int count){
        String str = "";
        for (int i = 0; i < count; i++) {
            str += "a";
        }
    }

    public void method2(int count){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append("a");
        }
    }
    //stringbuild初始容量16 过程中需要扩容  所以直接定义好容量
    public void method3(int count){
        StringBuilder stringBuilder = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            stringBuilder.append("a");
        }
    }

    @Test
    public void test4(){
        String ab = new String("ab");
        String t = "ab";
        ab.intern();
        System.out.println(t==ab);
    }

    @Test
    public void test5(){
        String s1 = "ab";
        String s2 = new String("a") + new String("b");
        System.out.println(s1 == s2);
    }

    @Test
    public void test6(){
        String s1 = new String("a") + new String("b");
        //串池中没有"ab"则把堆中"ab"对象的引用地址复制一份放到串池中
        s1.intern();
        //这个时候的"ab"其实是堆空间中ab的引用地址
        String s2 = "ab";
        System.out.println(s1==s2);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
