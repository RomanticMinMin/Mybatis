package com.xing.dao;

import com.xing.pojo.User;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlsession = MybatisUtils.getSqlsession();


        //执行SQL
        UserMapper mapper= sqlsession.getMapper(UserMapper.class);
        User user  = mapper.getUserById(2);


            System.out.println(user);


        //关闭sqlSession
        sqlsession.close();
    }
    //select * from mybatis.user where id = #{id}
    //类型处理器
    //select id,name,pwd as password from mybatis.user where id = #{id}



}
