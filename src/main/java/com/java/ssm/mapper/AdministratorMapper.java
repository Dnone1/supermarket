package com.java.ssm.mapper;

import com.java.ssm.pojo.Administrator;
import org.apache.ibatis.annotations.Param;

public interface AdministratorMapper {

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    Administrator adminLogin(@Param("username") String username , @Param("password") String password) ;

}
