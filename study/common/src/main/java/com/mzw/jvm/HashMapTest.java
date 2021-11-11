package com.mzw.jvm;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    private final int num = 11;

    public static void main(String[] args) {
        HashMapTest hashMapTest = new HashMapTest();
        hashMapTest.add();
    }

    public final int add(){
//        num = num + 2;
        Map<String,Object> map = new HashMap<>();
        map.put("a","a");
        map.put("a","b");
        return num;
    }
}
