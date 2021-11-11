package com.mzw.designpattern.builder;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.builder
 * @AUTHOR: mzw
 * @DATE: 2021/5/19
 */
public abstract class HouseBuilder {

    House house = new House();
    abstract void builderBasic();
    abstract void builderWalls();
    abstract void roofed();

    public House getHouse(){
        return house;
    }
}
