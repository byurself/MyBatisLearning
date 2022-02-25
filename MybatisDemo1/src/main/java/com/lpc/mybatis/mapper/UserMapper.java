package com.lpc.mybatis.mapper;

import com.lpc.mybatis.pojo.User;

import java.util.List;

/**
 * @author byu_rself
 * @date 2022/2/23 16:07
 *
 * Mybatis面向接口编程的两个一致：
 * 1、映射文件的namespace要和mapper接口的全类名保持一致
 * 2、映射文件中SQL语句的id要和mapper接口中的方法名一致
 *
 * 表->实体类->mapper接口->映射文件
 */
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();
}
