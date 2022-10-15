package com.xing.dao;

import com.xing.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {


    @Select("select * from user")
    List<User> getUsers();
}
