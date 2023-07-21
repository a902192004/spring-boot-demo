package com.demo.gateway.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;


/**
 * 自定義全局過濾
 */
@Component
@Slf4j
public class GlobalFilterConfig implements GlobalFilter, Ordered {
    /**
     * 過濾方法
     * 過濾器鏈模式；責任鏈模式
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 針對請求的過濾，拿到請求的header、url、參數等
        // HttpServletRequest  (web)
        // ServerHttpRequest   (webFlux響應式）
        ServerHttpRequest request = exchange.getRequest();

        String path = request.getURI().getPath();
        log.info("path:[{}]", path);

        HttpHeaders headers = request.getHeaders();

        String methodName = request.getMethod().name();

        //IPV4、IPV6地址
        String hostName = request.getRemoteAddress().getHostName();

        String ip = request.getHeaders().getHost().getHostString();

        // 響應式相關數據
        ServerHttpResponse response = exchange.getResponse();
        // 設置編碼
        response.getHeaders().set("content-type", "application/json;charset=utf-8");

//        HashMap<String, Object> map = new HashMap<>(4);
//        map.put("code", HttpStatus.UNAUTHORIZED.value());
//        map.put("msg", "未授權");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        // 將一個map轉成一個字節數組
//        byte[] bytes = new byte[0];
//        try {
//            bytes = objectMapper.writeValueAsBytes(map);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        // 通過buffer工廠將字節數組包裝成一個數據包
//        DataBuffer wrap = response.bufferFactory().wrap(bytes);
//        return response.writeWith(Mono.just(wrap));

        // 到下一個過濾器
        return chain.filter(exchange);
    }

    /**
     * 指定順序的方法，越小越先執行
     */
    @Override
    public int getOrder() {
        return 0;
    }

}
