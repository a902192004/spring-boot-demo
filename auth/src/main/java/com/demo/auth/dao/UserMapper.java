package com.demo.auth.dao;

import com.demo.auth.model.dto.user.RegisterDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO role_user (user_id, email, password, phone) VALUES (#{userId}, #{email}, #{password}, #{phone})")
    int registerUser(RegisterDto registerDto);

}
