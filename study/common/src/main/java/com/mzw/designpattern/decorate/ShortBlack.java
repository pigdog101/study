package com.mzw.designpattern.decorate;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.decorate
 * @AUTHOR: mzw
 * @DATE: 2021/5/21
 */
public class ShortBlack extends Coffee {
    public ShortBlack(){
        super.setDes("单品咖啡");
        super.setPrice(2.00f);
    }
}
