package com.demo.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("register")
    public void register() {

    }

    @PostMapping("login")
    public void login() {

    }

    @PostMapping("logout")
    public void logout(){

    }

}
