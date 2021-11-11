package com.mzw.jvm;

import org.junit.jupiter.api.Test;

//类型转化
public class ClassCastTest {
    //宽化类型转化
    public void upCast(){
        int i = 10;
        long l = i;
        float f = i;
        double d  = i;

        f = l;
        d = l;
        d = f;
    }
    //宽化类型转换精度损失的问题
    @Test
    public void upCast2(){
        int i = 1234561222;
        float f = i;
        System.out.println(f);
    }
}
