package com.iweb.pojo;

import java.io.Serializable;

/**
 * @Author Chentyit
 * @Date 2019/7/30 22:56
 * @Description: 垃圾实体类（映射数据库垃圾表）
 */
public class Garbage implements Serializable {

    /**
     * 垃圾 ID
     */
    private int gId;

    /**
     * 垃圾名称
     */
    private String gName;

    /**
     * 垃圾类别 ID
     */
    private int gClassId;

    public Garbage() {
    }

    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getgClassId() {
        return gClassId;
    }

    public void setgClassId(int gClassId) {
        this.gClassId = gClassId;
    }

    @Override
    public String toString() {
        return "Garbage{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", gClassId=" + gClassId +
                '}';
    }
}
