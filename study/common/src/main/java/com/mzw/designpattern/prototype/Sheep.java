package com.mzw.designpattern.prototype;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.prototype
 * @AUTHOR: mzw
 * @DATE: 2021/5/18
 */
public class Sheep implements Cloneable{
    private String name;
    private Integer age;
    private Sheep friend;

    public Sheep(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Sheep getFriend() {
        return friend;
    }

    public void setFriend(Sheep friend) {
        this.friend = friend;
    }

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

    @Override
    protected Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return this.getName() + "-" + this.getAge();
    }
}
