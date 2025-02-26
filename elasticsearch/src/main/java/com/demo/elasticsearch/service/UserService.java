package com.demo.elasticsearch.service;

import com.demo.elasticsearch.entity.User;
import com.demo.elasticsearch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserService {

//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    public void insertUser(User user) {
        // 新增
        user.setId(UUID.randomUUID().toString());
//        Object result = userRepository.save(user);
//        System.out.println("result:" + result);
//        System.out.println(userRepository.findByAccount(user.getAccount()));
    }

}
