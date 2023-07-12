package com.java.ssm.service.Impl;

import com.java.ssm.mapper.AdministratorMapper;
import com.java.ssm.pojo.Administrator;
import com.java.ssm.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper ;

    @Override
    public Administrator adminLogin(String username, String password) {
        return administratorMapper.adminLogin(username, password);
    }

}
