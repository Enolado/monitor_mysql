package com.lwl.monitor.mapper;

import com.lwl.monitor.entity.Users;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lwl
 * @create 2021/11/11 10:31
 */
@Repository
public interface UsersMapper {

    /**
     * 对应users表
     * @return List<Users>
     */
    @Select("SELECT IFNULL(USER,'backgroundThread')USER,CURRENT_CONNECTIONS,TOTAL_CONNECTIONS FROM users")
    @Results({
            @Result(property = "user",column = "user"),
            @Result(property = "currentConnections",column = "CURRENT_CONNECTIONS"),
            @Result(property = "totalConnections",column = "TOTAL_CONNECTIONS")
    })
    public List<Users> getAllConnections();
}
