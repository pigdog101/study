package com.mzw.designpattern.flyweight;

import javax.jws.WebMethod;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.flyweight
 * @AUTHOR: mzw
 * @DATE: 2021/6/1
 */
public class ConcreteWebSite extends WebSite {

    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use() {
        System.out.println("网站的发布形式："+type);
    }
}
