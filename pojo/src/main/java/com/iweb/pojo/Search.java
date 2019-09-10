package com.iweb.pojo;

import java.io.Serializable;

/**
 * @Author Chentyit
 * @Date 2019/7/30 22:57
 * @Description: 查询历史记录（ID，垃圾名称，某个垃圾被查次数）
 */
public class Search implements Serializable {

    /**
     * 查询历史 ID
     */
    private int searchId;

    /**
     * 查询过的垃圾名
     */
    private String garbageName;

    /**
     * 查询某个垃圾次数
     */
    private long searchNum;

    public Search() {
    }

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public String getGarbageName() {
        return garbageName;
    }

    public void setGarbageName(String garbageName) {
        this.garbageName = garbageName;
    }

    public long getSearchNum() {
        return searchNum;
    }

    public void setSearchNum(long searchNum) {
        this.searchNum = searchNum;
    }

    @Override
    public String toString() {
        return "Search{" +
                "searchId=" + searchId +
                ", garbageName='" + garbageName + '\'' +
                ", searchNum=" + searchNum +
                '}';
    }
}
