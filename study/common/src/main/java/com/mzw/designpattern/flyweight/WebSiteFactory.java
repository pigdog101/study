package com.mzw.designpattern.flyweight;

import java.util.HashMap;
import java.util.List;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.flyweight
 * @AUTHOR: mzw
 * @DATE: 2021/6/1
 */
public class WebSiteFactory {
    HashMap<String,ConcreteWebSite> concreteWebSiteHashMap = new HashMap<>();
    public WebSite getWebSite(String type){
        if (!concreteWebSiteHashMap.containsKey(type)){
            ConcreteWebSite webSite = new ConcreteWebSite(type);
            concreteWebSiteHashMap.put(type,webSite);
            return webSite;
        }
        return concreteWebSiteHashMap.get(type);
    }
}
