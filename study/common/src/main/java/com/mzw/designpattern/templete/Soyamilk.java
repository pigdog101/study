package com.mzw.designpattern.templete;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.templete
 * @AUTHOR: mzw
 * @DATE: 2021/6/6
 */
public abstract class Soyamilk {
    public final void make(){
        select();
        add();
        beat();
    }
    private void select(){

    }
    abstract void add();

    private void beat(){

    }
}
