package com.demo.elasticsearch.controller;


import com.demo.elasticsearch.entity.User;
//import com.demo.elasticsearch.repository.UserRepository;
import com.demo.elasticsearch.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }

}
