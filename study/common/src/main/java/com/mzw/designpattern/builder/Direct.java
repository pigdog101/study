package com.mzw.designpattern.builder;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.builder
 * @AUTHOR: mzw
 * @DATE: 2021/5/19
 */
public class Direct {
    private HouseBuilder houseBuilder;

    public HouseBuilder getHouseBuilder() {
        return houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House build(){
        houseBuilder.builderBasic();
        houseBuilder.builderWalls();
        houseBuilder.roofed();
        return houseBuilder.getHouse();
    }
}
