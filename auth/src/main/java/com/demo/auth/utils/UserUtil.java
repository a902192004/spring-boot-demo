package com.demo.auth.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserUtil {

    /**
     * 獲取用戶鹽值，用於加密用戶密碼
     * @param loginName
     * @return
     */
    public static String getUserSalt(String loginName){
        // 加鹽
        String[] salts = {"sun","moon","star","sky","cloud","fog","rain","wind","rainbow", };
        int hashCode = loginName.hashCode() + 159;
        int mod = Math.abs( hashCode % 9 );

        return salts[mod];
    }

    public static String encryptPassword(String password,String salt) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password + salt);
    }

    public static void main(String[] args) {
        String loginPwd = getUserSalt("222");
        encryptPassword("1232", )
        System.out.println("loginPwd : " + loginPwd);
    }
}
