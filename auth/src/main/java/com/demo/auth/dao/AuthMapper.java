package com.demo.auth.dao;

import com.demo.auth.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthMapper {

    @Select("SELECT user_id, account FROM role_user ")
    List<UserPO> selectUser();

}
