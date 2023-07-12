package com.java.ssm.service;

import com.java.ssm.pojo.Administrator;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.ORBPackage.InconsistentTypeCode;
import org.springframework.web.bind.annotation.RequestMapping;

public interface AdministratorService {

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    Administrator adminLogin(String username , String password) ;


}
