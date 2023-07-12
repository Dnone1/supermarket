package com.java.ssm.service.Impl;

import com.java.ssm.mapper.UserMapper;
import com.java.ssm.pojo.Administrator;
import com.java.ssm.pojo.User;
import com.java.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper ;

    @Override
    public User userLogin(String username, String password) {
        return userMapper.userLogin(username , password);
    }

    @Override
    public User uploadUser(Integer id) {
        return userMapper.uploadUser(id);
    }

    @Override
    public Integer administratorUserUpload(User user) {
        return userMapper.administratorUserUpload(user);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

	@Override
	public User getUserByid(Integer id) {
		
		return userMapper.getUserByid(id);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.getUserByName(name);
	}


}
