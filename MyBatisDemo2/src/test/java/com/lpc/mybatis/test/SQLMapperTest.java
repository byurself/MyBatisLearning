package com.lpc.mybatis.test;

import com.lpc.mybatis.mapper.SQLMapper;
import com.lpc.mybatis.pojo.User;
import com.lpc.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author byu_rself
 * @date 2022/2/26 14:00
 */
public class SQLMapperTest {

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null,"王五","123",23,"男","123@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        System.out.println(mapper.getUserByTableName("t_user"));
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        System.out.println(mapper.deleteMore("1,2,3,4"));
    }

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        System.out.println(mapper.getUserByLike("a"));
    }

}
