package com.demo.auth.controller;

import com.demo.auth.model.dto.user.RegisterDto;
import com.demo.auth.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

//    @Resource
//    private final TokenEndpoint tokenEndpoint;

//    public final UserService userService;



    @PostMapping("register")
    public void register(@Valid RegisterDto registerDto) {
        userService.register(registerDto);
    }

//    @PostMapping("login")
//    public void login(Principal principal) {
//        Map<String, Object> result = new HashMap<>();
//        try {
//            OAuth2AccessToken postAccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
//
//
//            result.put("data", Objects.nonNull(postAccessToken.getAdditionalInformation()) ? postAccessToken.getAdditionalInformation().get("profile") : null);
//            result.put("code", 200);
//            result.put("msg", "操作成功");
//            result.put("access_token", postAccessToken.getValue());
//            result.put("expiration", postAccessToken.getExpiration());
//            result.put("expires_in", postAccessToken.getExpiresIn());
//            result.put("token_type", postAccessToken.getTokenType());
//
//
//        } catch (HttpRequestMethodNotSupportedException e) {
//            log.error("登录失败");
//        }
//    }

}
