package com.iweb.common.utilobj;

import java.io.Serializable;

/**
 * @Author Chentyit
 * @Date 2019/8/8 08:22
 * @Description: 每个垃圾是什么分类
 */
public class GarOneOfClazz implements Serializable {

    private String garName;
    private String claName;

    public GarOneOfClazz() {
    }

    public String getGarName() {
        return garName;
    }

    public void setGarName(String garName) {
        this.garName = garName;
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }

    @Override
    public String toString() {
        return "GarOneOfClazz{" +
                "garName='" + garName + '\'' +
                ", claName='" + claName + '\'' +
                '}';
    }
}
