package com.xing.dao;

import com.xing.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    //根据ID查询用户
    User getUserById(int id);

    //
   List<User> getUserByLimit(Map<String,Integer> map);

}