package com.mzw.designpattern.prototype.deepclone;

import java.io.Serializable;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.prototype.deepclone
 * @AUTHOR: mzw
 * @DATE: 2021/5/18
 */
public class DeepCloneTarget implements Serializable,Cloneable {
    private static final Long serialVersionUID = 1L;

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
