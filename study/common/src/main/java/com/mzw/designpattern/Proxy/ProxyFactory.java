package com.mzw.designpattern.Proxy;

import java.lang.reflect.Proxy;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Proxy
 * @AUTHOR: mzw
 * @DATE: 2021/6/2
 */
public class ProxyFactory  {
    //维护目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getTargetInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),(proxy, method, args) -> {
            System.out.println("代理开始");
            Object invoke = method.invoke(target, args);
            return invoke;
        });
    }
}
