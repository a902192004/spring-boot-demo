package com.demo.gateway.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("hb")
    public String health(){
        return "success";
    }

}
