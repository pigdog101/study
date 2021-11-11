package com.mzw.designpattern.adapter.objectadapter;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.adapter
 * @AUTHOR: mzw
 * @DATE: 2021/5/19
 */
public class Phone {
    public void charging(Voltage5V voltage5V){
        if (voltage5V.output5V()==5){
            System.out.println("可以充电");
        }else {
            System.out.println("不能充电");
        }
    }
}
