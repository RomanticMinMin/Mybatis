package com.xing.dao;

import com.xing.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

     User queryUserById(@Param("id") int id);


}
