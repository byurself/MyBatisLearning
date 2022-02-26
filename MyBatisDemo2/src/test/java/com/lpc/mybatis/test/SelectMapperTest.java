package com.lpc.mybatis.test;

import com.lpc.mybatis.mapper.SelectMapper;
import com.lpc.mybatis.pojo.User;
import com.lpc.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author byu_rself
 * @date 2022/2/26 13:30
 */
public class SelectMapperTest {

    /**
     * MyBatis的各种查询功能：
     * 1、若查询出的数据只有一条
     * a>可以通过实体类对象接收
     * b>可以通过list集合接收
     * c>可以通过map集合接收，结果例如：{password=123456, sex=男, id=6, age=23, email=123456@qq.com, username=admin}
     * 2、若查询出的数据有多条
     * a>可以通过实体类类型的list集合接收
     * b>可以通过map类型的list集合接收
     * c>可以在map接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map集合中
     * 注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
     * <p>
     * MyBatis中设置了默认的类型别名:
     * java.lang.Integer -> int,integer
     * int -> _int,_integer
     * Map -> map
     * String -> string
     */

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(6));
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(6);
        System.out.println(user);
    }

}
