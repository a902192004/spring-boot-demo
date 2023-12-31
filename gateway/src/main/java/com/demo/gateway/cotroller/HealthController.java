package com.demo.gateway.cotroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthController {

    @GetMapping("hb")
    public String health(){
        log.info("gateway service health");
        return "success";
    }

}
