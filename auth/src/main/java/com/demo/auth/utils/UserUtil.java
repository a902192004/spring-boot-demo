package com.demo.auth.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;

@Slf4j
@UtilityClass
public class UserUtil {

    /**
     * 密碼加鹽
     * @param password
     */
    public String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 比對密碼
     * @param password
     * @param encodePwd
     */
    public boolean checkPwd(String password, String encodePwd) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean bool = passwordEncoder.matches(password, encodePwd);
        log.debug("驗證密碼結果:{}", bool);
        return bool;
    }

    public static void main(String[] args) {
        String encryptPwd = encryptPassword("22222");
        System.out.println(encryptPwd);
        System.out.println(checkPwd("22222", "$2a$10$fKqy8.IXt5prMzYC.G4/YOGFZLLnYmQnUU5F8pvry83/zLkHJR03m"));
        System.out.println(new BigDecimal(0.01).compareTo(new BigDecimal(0)));
    }
}
