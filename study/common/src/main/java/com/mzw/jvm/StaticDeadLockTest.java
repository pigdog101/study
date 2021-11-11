package com.mzw.jvm;

public class StaticDeadLockTest {
    public static void main(String[] args) {
        SyncronizedStaticThread t1 = new SyncronizedStaticThread("A");
        t1.start();
        SyncronizedStaticThread t2 = new SyncronizedStaticThread("B");
        t2.start();
    }
}

class SyncronizedStaticThread extends Thread{
    public String name;

    public SyncronizedStaticThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try {
            Class.forName("com.mzw.jvm.Static" + name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class StaticA{
    static {
        try {
            Thread.sleep(1000);
            Class.forName("com.mzw.jvm.StaticB");
        } catch (ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class StaticB{
    static {
        try {
            Thread.sleep(1000);
            Class.forName("com.mzw.jvm.StaticA");
        } catch (ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

