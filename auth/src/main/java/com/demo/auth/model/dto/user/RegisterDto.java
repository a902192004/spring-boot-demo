package com.demo.auth.model.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter

public class RegisterDto {

    @NotNull(message = "email not null")
    @Email
    private String email;

    @Pattern(regexp = "09[0-9]{10}",  flags = Pattern.Flag.UNICODE_CASE, message = "需符合台灣地區電話號碼格式")
    private String phone;

    @NotNull(message = "password not null")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\s\\S]{8,16}$", flags = Pattern.Flag.UNICODE_CASE, message = "密碼須包含至少一個大寫字母，小寫字母，數字")
    private String password;


}
