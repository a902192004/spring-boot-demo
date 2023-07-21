package com.demo.gateway.cotroller;

import org.springframework.web.bind.annotation.GetMapping;

public class FallBackController {

    @GetMapping("/fallback")
    public String fallback() {
        System.out.println("error fall back ");
        return "fail";
    }

}
