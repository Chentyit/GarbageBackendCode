package com.iweb.pojo;

import java.io.Serializable;

/**
 * @Author Chentyit
 * @Date 2019/7/30 23:00
 * @Description: 用户实体类（数据库用户映射表）
 */
public class SysUser implements Serializable {

    /**
     * 用户 ID
     */
    private int userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    public SysUser() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
