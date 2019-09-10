package com.iweb.service;

import com.iweb.pojo.SysUser;

/**
 * @Author Chentyit
 * @Date 2019/8/1 09:39
 * @Description: 用户服务层接口
 */
public interface SysUserService {

    /**
     * 注册用户
     * @param username 注册用户名
     * @param password 注册用户密码
     * @return 返回注册成功标志
     */
    public boolean registeredUser(String username, String password);

    /**
     * 用户登录
     * @param username 登录名
     * @param password 登录密码
     * @return 返回登录结果
     */
    public boolean userLogin(String username, String password);

    /**
     * 修改用户信息
     * @param username 用户名
     * @param newName 新用户名
     * @param newPassword 新用户密码
     * @return 返回修改结果标志
     */
    public boolean modifyUserInfo(String username, String newName, String newPassword);
}
