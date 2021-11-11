package com.mzw.designpattern.adapter.objectadapter;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.adapter
 * @AUTHOR: mzw
 * @DATE: 2021/5/19
 */
public class Adapter implements Voltage5V {

    private Voltage220V voltage220V;

    public Adapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        if (voltage220V!=null) {
            int output220 = voltage220V.output220();
            int output5 = output220 / 44;
            return output5;
        }else {
            return 0;
        }
    }
}
