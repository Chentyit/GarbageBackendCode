package com.iweb.controller;

import com.iweb.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Chentyit
 * @Date 2019/8/1 10:49
 * @Description:
 */
@RestController
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 注册用户
     * @param username 用户名
     * @param password 用户密码
     * @return 返回注册结果
     */
    @RequestMapping("/user/registered")
    public boolean registered(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        // 去除参数首位空格
        username = username.trim();
        password = password.trim();
        // 判断参数是否有效
        if ("".equals(username) || "".equals(password)) {
            return false;
        }
        // 注册用户
        return sysUserService.registeredUser(username, password);
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return 返回登录结果
     */
    @RequestMapping("/user/login")
    public boolean login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        // 去除参数首位空格
        username = username.trim();
        password = password.trim();
        // 判断参数是否有效
        if ("".equals(username) || "".equals(password)) {
            return false;
        }
        // 登录用户
        return sysUserService.userLogin(username, password);
    }

    /**
     * 修改用户信息
     * @param username 用户名
     * @param newName 新用户名
     * @param newPassword 新用户密码
     * @return 返回修改结果标志
     */
    @RequestMapping("/user/modify")
    public boolean modify(
            @RequestParam("username") String username,
            @RequestParam("newName") String newName,
            @RequestParam("newPassword") String newPassword) {
        // 去除参数首位空格
        username = username.trim();
        newName = newName.trim();
        newPassword = newPassword.trim();
        // 判断参数是否有效
        if ("".equals(username) || "".equals(newName) || "".equals(newPassword)) {
            return false;
        }
        // 修改用户信息
        if (newName.length() == 0) {
            return sysUserService.modifyUserInfo(username, null, newPassword);
        } else if (newPassword.length() == 0) {
            return sysUserService.modifyUserInfo(username, newName, null);
        } else {
            return false;
        }
    }
}
