package com.lpc.mybatis.test;

import com.lpc.mybatis.mapper.DeptMapper;
import com.lpc.mybatis.mapper.EmpMapper;
import com.lpc.mybatis.pojo.Emp;
import com.lpc.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author byu_rself
 * @date 2022/2/26 16:00
 */
public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况：
     * a>为字段起别名，保持和属性名一致
     * b>设置全局配置，将_自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c>通过resultMap设置自定义的映射关系
     *     <resultMap id="empResultMap" type="Emp">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     *     </resultMap>
     *
     * 处理多对一的映射关系：
     * a>级联属性赋值
     * b>association标签
     * c>分布查询
     *      优点：能实现延迟加载
     *
     * 处理一对多的映射关系
     * a>collection
     * b>分步查询
     */

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        System.out.println(mapper.getDeptAndEmpByStepOne(1).getDeptName());
    }

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        System.out.println(mapper.getDeptAndEmp(1));
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp.getEmpName());
        System.out.println("****************************");
        System.out.println(emp.getDept());
    }

    @Test
    public void testEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(3);
        System.out.println(emp);
    }

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }

}
