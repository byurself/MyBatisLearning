package com.lpc.mybatis.mapper;

import com.lpc.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author byu_rself
 * @date 2022/2/27 22:10
 */
public interface CacheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(Emp emp);

}
