package com.demo.auth.service;

import com.demo.auth.dao.AuthMapper;
import com.demo.auth.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final AuthMapper authMapper;

    public TestService(AuthMapper authMapper){
        this.authMapper = authMapper;
    }

    public void test() {

        List<UserPO> userPO = authMapper.selectUser();
        System.out.println("userPO : " + userPO);
    }

}
