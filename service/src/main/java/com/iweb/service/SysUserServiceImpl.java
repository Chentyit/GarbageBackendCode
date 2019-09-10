package com.iweb.service;

import com.iweb.mapper.SysUserMapper;
import com.iweb.pojo.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author Chentyit
 * @Date 2019/8/1 09:39
 * @Description: 实现用户注册业务
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    /**
     * 注入 SysUserMapper
     * 可以直接使用 Dao 层接口
     */
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 注册用户
     * @param username 注册用户名
     * @param password 注册用户密码
     * @return 返回注册成功标志
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean registeredUser(String username, String password) {
        // 注册前先查看数据库中是否存在该用户
        // 使用用户名判断（不允许模糊查询）
        SysUser sysUser = sysUserMapper.findUserByUserName(username);
        // 如果存在直接返回 false
        if (sysUser != null) {
            return false;
        }
        // 不存在就开始注册并返回注册成功
        return sysUserMapper.registeredUser(username, password);
    }

    /**
     * 用户登录
     * @param username 登录名
     * @param password 登录密码
     * @return 返回登录结果
     */
    @Override
    public boolean userLogin(String username, String password) {
        // 冲数据库中查找用户
        SysUser sysUser = sysUserMapper.findUserByNameAndPassword(username, password);

        if (sysUser != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改用户信息
     * @param username 用户名
     * @param newName 新用户名
     * @param newPassword 新用户密码
     * @return 返回修改结果标志
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyUserInfo(String username, String newName, String newPassword) {
        // 根据用户名超出用户信息
        SysUser sysUser = sysUserMapper.findUserByUserName(username);

        // 获取修改结果标志
        boolean modifyFlag = sysUserMapper.modifyUserNameOrPassword(sysUser.getUserId(), sysUser.getUsername(), newName, newPassword);

        // 返回修改结果
        if (modifyFlag) {
            return true;
        } else {
            return false;
        }
    }
}
