package com.mzw.designpattern.bridge;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.bridge
 * @AUTHOR: mzw
 * @DATE: 2021/5/20
 */
public class UPRightPhone extends Phone {
    public UPRightPhone(Brand brand) {
        super(brand);
    }
    @Override
    public void open() {
        super.open();
        System.out.println("直立手机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("直立手机");
    }
}
