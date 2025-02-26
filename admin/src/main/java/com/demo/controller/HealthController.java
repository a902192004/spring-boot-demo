package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hb")
@RestController
public class HealthController {

    @GetMapping("/test")
    public String health() {
        return "success";
    }

}
