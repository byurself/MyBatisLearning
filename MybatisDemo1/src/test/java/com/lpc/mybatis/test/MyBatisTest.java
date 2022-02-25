package com.lpc.mybatis.test;

import com.lpc.mybatis.mapper.UserMapper;
import com.lpc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author byu_rself
 * @date 2022/2/23 16:21
 */
public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        // 加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 获取SqlSession(默认不自动提交事务，若需要自动提交事务，可以使用sqlSessionFactory.openSession(true))
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 测试功能
        int result = mapper.insertUser();
        // 提交事务
        // sqlSession.commit();
        System.out.println("result:" + result);
    }

    @Test
    public void testCRUD() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // mapper.updateUser();
        // mapper.deleteUser();
        // User user = mapper.getUserById();
        List<User> userList = mapper.getAllUser();
        userList.forEach(user -> System.out.println(user));
    }
}
