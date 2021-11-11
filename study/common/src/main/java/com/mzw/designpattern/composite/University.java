package com.mzw.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.composite
 * @AUTHOR: mzw
 * @DATE: 2021/5/24
 */
public class University extends OrganizationComponent{

    List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void print() {
        organizationComponentList.forEach((x)->System.out.println(x.getName()));
    }

    @Override
    public void add(OrganizationComponent component) {
        organizationComponentList.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        organizationComponentList.remove(component);
    }
}
