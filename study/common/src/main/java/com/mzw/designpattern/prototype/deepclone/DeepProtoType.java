package com.mzw.designpattern.prototype.deepclone;

import java.io.*;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.prototype.deepclone
 * @AUTHOR: mzw
 * @DATE: 2021/5/18
 */
public class DeepProtoType implements Serializable,Cloneable {

    private static final Long serialVersionUID = 1L;
    private String name;
    private Integer age;
    private DeepCloneTarget deepCloneTarget;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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

    public DeepCloneTarget getDeepCloneTarget() {
        return deepCloneTarget;
    }

    public void setDeepCloneTarget(DeepCloneTarget deepCloneTarget) {
        this.deepCloneTarget = deepCloneTarget;
    }

    public Object deepClone(){
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        DeepProtoType deepProtoType = null;
        try{
            //将this已对象流输出
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //再以对象流输入获得新的DeepProtoType对象
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            deepProtoType = (DeepProtoType)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return deepProtoType;
    }

    public static void main(String[] args) {
        DeepProtoType protoType = new DeepProtoType();
        DeepCloneTarget cloneTarget = new DeepCloneTarget();
        cloneTarget.setAge(1);
        cloneTarget.setName("zzz");
        protoType.setName("mzw");
        protoType.setDeepCloneTarget(cloneTarget);
        DeepProtoType protoType1 = (DeepProtoType)protoType.deepClone();
        System.out.println(protoType.getDeepCloneTarget().hashCode() + "---" + protoType1.getDeepCloneTarget().hashCode());
    }
}
