package com.demo.auth.service;

import com.demo.auth.dao.UserMapper;
import com.demo.auth.model.dto.user.RegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;


    public void login() {

    }

    /**
     * 註冊會員
     * @param registerDto 請求參數
     */
    public void register(RegisterDto registerDto) {
        // 存入user表
        userMapper.registerUser(registerDto);
    }



}
