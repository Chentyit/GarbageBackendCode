package com.iweb.mapper;

import com.iweb.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Chentyit
 * @Date 2019/8/1 09:18
 * @Description: 用户 Dao 层接口
 */
public interface SysUserMapper {

    /**
     * 通过完整用户名查询用户（不支持使用模糊查询）
     * @param username 传入完整用户名
     * @return 返回查找成功标志
     */
    public SysUser findUserByUserName(@Param("username") String username);

    /**
     * 注册用户
     * @param username 注册用户名
     * @param password 注册用户密码
     * @return 返回注册是否成功标志
     */
    public boolean registeredUser(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名和密码查找唯一用户
     * @param username 用户名
     * @param password 用户密码
     * @return 返回查找到的用户
     */
    public SysUser findUserByNameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 修改用户名或者密码
     * @param userId 用户 ID
     * @param username 原用户名
     * @param newName 新用户名
     * @param newPassword 新密码
     * @return 返回修改结果
     */
    public boolean modifyUserNameOrPassword(
            @Param("userId") int userId,
            @Param("username") String username,
            @Param("newName") String newName,
            @Param("newPassword") String newPassword);
}
