package com.lpc.mybatis.mapper;

import com.lpc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author byu_rself
 * @date 2022/2/25 22:49
 */
public interface ParameterMapper {

    /**
     * 验证登录(使用@Param)
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录(参数为map)
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 查询所有的员工信息
     */
    List<User> getAllUser();

}
