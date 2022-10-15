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
        UserMapper userDao = sqlsession.getMapper(UserMapper.class);
        List<User>userlist = userDao.getUserList();
        for (User user : userlist) {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlsession.close();
    }


}
