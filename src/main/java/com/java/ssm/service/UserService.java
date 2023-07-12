package com.java.ssm.service;

import com.java.ssm.pojo.Administrator;
import com.java.ssm.pojo.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserService {
	
	/**
	 * 根据用户id查询用户信心
	 * @param id
	 * @return
	 */
	User getUserByid( Integer id) ;
	
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    User userLogin(String username , String password ) ;

    /*
    根据id获取个人信息
     */

    User uploadUser(Integer id);

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    Integer administratorUserUpload(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 获取所用用户信息
     * @return
     */
    List<User> getUsers();

    /**
     * 删除用户
     * @param id
     * @return
     */
    Integer deleteUser(Integer id);
    
    User getUserByName(String name) ;
}
