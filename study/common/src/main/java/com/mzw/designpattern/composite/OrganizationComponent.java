package com.mzw.designpattern.composite;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.composite
 * @AUTHOR: mzw
 * @DATE: 2021/5/24
 */
public abstract class OrganizationComponent {
    private String name;
    private String desc;
    public void add(OrganizationComponent component){
        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent component){
        throw new UnsupportedOperationException();
    }

    public OrganizationComponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    protected abstract void print();
}
