package com.mzw.designpattern.builder;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.builder
 * @AUTHOR: mzw
 * @DATE: 2021/5/19
 */
public class House {
    private String basic;
    private String walls;
    private String roof;

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }
}
