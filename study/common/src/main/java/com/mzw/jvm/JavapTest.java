package com.mzw.jvm;

public class JavapTest {
    private int num;
    boolean flag;
    protected char gender;
    public String info;

    public static final int COUNTS = 1;

    static {
        String url = "mzw";
    }
    {
        info = "java";
    }
    public JavapTest(){}

    public JavapTest(Boolean flag){}

    private void methodPrivate(){}

    int getNum(int num){
        return num;
    }

    protected char showGender(){
        return gender;
    }
    public void showInfo(){
        int i = 10;
        System.out.println(info + i);
    }
}
