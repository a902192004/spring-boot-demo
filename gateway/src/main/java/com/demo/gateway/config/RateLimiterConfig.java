package com.demo.gateway.config;


import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

//    @Bean
//    public KeyResolver ipKeyResolver() {
//        // IP限流
//        return exchange -> {
//            String remoteIp = IpUtil.getClientSimpleIp(exchange.getRequest(), platform);
//            return Mono.just(remoteIp);
//        };
//    }

}
