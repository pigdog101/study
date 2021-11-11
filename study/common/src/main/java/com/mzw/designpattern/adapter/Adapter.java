package com.mzw.designpattern.adapter;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.adapter
 * @AUTHOR: mzw
 * @DATE: 2021/5/19
 */
public class Adapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        int output220 = output220();
        int output5 = output220 / 44;
        return output5;
    }
}
