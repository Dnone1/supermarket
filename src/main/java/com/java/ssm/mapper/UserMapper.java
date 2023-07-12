package com.java.ssm.mapper;

import com.java.ssm.pojo.Administrator;
import com.java.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*
    登陆
     */
    User userLogin(@Param("username") String username , @Param("password") String password ) ;

    /*
    根据id获取个人信息
     */
    User uploadUser(@Param("id") Integer id);

    /**
     * 插入信息
     * @param user
     * @return
     */

    Integer administratorUserUpload(User user);

    /**
     * 插入用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 获取用户所用信息
     * @return
     */
    List<User> getUsers();

    /**
     * 删除用户
     * @param id
     * @return
     */
    Integer deleteUser(@Param("id") Integer id);
    
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserByid(@Param("id") Integer id) ;
    
    User getUserByName(@Param("name") String name) ;
}
