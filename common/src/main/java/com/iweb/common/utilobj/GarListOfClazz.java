package com.iweb.common.utilobj;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Chentyit
 * @Date 2019/8/6 21:48
 * @Description: 用于映射详细信息的实体类（类别名 ———— 对应的垃圾列表）
 */
public class GarListOfClazz implements Serializable {

    private String claName;
    private List<String> garNameList;

    public GarListOfClazz() {
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }

    public List<String> getGarNameList() {
        return garNameList;
    }

    public void setGarNameList(List<String> garNameList) {
        this.garNameList = garNameList;
    }

    @Override
    public String toString() {
        return "GarOfClazz{" +
                "claName='" + claName + '\'' +
                ", garNameList=" + garNameList +
                '}';
    }
}
