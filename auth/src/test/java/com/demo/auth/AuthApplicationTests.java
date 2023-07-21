package com.demo.auth;

import com.demo.auth.service.TestService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthApplicationTests {

    @Autowired
    TestService testService;

    @Test
    public void authTest(){
        testService.test();
    }

}
