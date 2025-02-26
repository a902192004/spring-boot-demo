package com.demo.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hb")
@RestController
@Slf4j
public class HealthController {

    @GetMapping("/test")
    public String health() {
        log.info("auth service health");

        return "success";
    }

}
