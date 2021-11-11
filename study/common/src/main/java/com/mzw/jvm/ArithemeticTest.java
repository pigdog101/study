package com.mzw.jvm;

import org.junit.jupiter.api.Test;

public class ArithemeticTest {

    @Test
    public static synchronized void test3(){
        int i = 10;
        i += 1;
//        i = i+1;
    }
}
