package com.mzw.designpattern.Factory.absfactory;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public abstract class Pizza {
    protected String name;
    abstract void prepare();

    public void bake(){
        System.out.println(name + " 正在准备");
    }

    public void cut(){
        System.out.println(name + " 正在切割");
    }

    public void pack(){
        System.out.println(name + " 正在包装");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
