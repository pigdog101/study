package com.mzw.designpattern.builder;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.builder
 * @AUTHOR: mzw
 * @DATE: 2021/5/19
 */
public class HighHouse extends HouseBuilder {
    @Override
    void builderBasic() {
        System.out.println("高楼打地基");
    }

    @Override
    void builderWalls() {
        System.out.println("高楼建墙");
    }

    @Override
    void roofed() {
        System.out.println("高楼盖顶");
    }
}
