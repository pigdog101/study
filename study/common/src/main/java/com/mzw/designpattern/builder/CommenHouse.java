package com.mzw.designpattern.builder;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.builder
 * @AUTHOR: mzw
 * @DATE: 2021/5/19
 */
public class CommenHouse extends HouseBuilder {
    @Override
    void builderBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    void builderWalls() {
        System.out.println("普通房子建墙");
    }

    @Override
    void roofed() {
        System.out.println("普通房子盖顶");
    }
}
