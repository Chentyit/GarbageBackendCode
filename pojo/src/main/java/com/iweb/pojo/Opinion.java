package com.iweb.pojo;

import java.io.Serializable;

/**
 * @Author Chentyit
 * @Date 2019/8/10 18:12
 * @Description:
 */
public class Opinion implements Serializable {

    private int opId;
    private String opDate;
    private String opAddress;
    private String opContent;

    public Opinion() {
    }

    public int getOpId() {
        return opId;
    }

    public void setOpId(int opId) {
        this.opId = opId;
    }

    public String getOpDate() {
        return opDate;
    }

    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }

    public String getOpAddress() {
        return opAddress;
    }

    public void setOpAddress(String opAddress) {
        this.opAddress = opAddress;
    }

    public String getOpContent() {
        return opContent;
    }

    public void setOpContent(String opContent) {
        this.opContent = opContent;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "opId=" + opId +
                ", opDate='" + opDate + '\'' +
                ", opAddress='" + opAddress + '\'' +
                ", opContent='" + opContent + '\'' +
                '}';
    }
}
