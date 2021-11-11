package com.mzw.designpattern.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Proxy
 * @AUTHOR: mzw
 * @DATE: 2021/6/4
 */
public class CglbProxyFactory implements MethodInterceptor {
    private Object target;

    public CglbProxyFactory(Object target) {
        this.target = target;
    }
    public Object getProxyFactory(){
        //1.创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类对象
        return enhancer.create();
    }
    //重写intercept 该方法会执行target的方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib代理开始");
        Object invoke = method.invoke(target, args);
        System.out.println("cglib代理结束");
        return invoke;
    }

    public static void main(String[] args) {
        CglbTeacherDao cglbTeacherDao = new CglbTeacherDao();
        CglbProxyFactory cglbProxyFactory = new CglbProxyFactory(cglbTeacherDao);
        CglbTeacherDao proxyFactory = (CglbTeacherDao)cglbProxyFactory.getProxyFactory();
        proxyFactory.teach();
    }
}
