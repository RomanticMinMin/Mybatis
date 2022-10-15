package com.xing.dao;

import com.xing.pojo.User;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//import java.util.logging.Logger;  应该导下面Apache的包
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

   static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void getUserByLimit(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",1);   //从下表0开始
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit (map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlsession.close();
    }
    @Test
    public void getUserByLimit2(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",4);
        List<User> user= mapper.getUserByLimit (map);
        for (User user1 : user) {
            System.out.println(user1);
        }

        sqlsession.close();

    }



    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlsession = MybatisUtils.getSqlsession();

        //执行SQL
        UserMapper mapper= sqlsession.getMapper(UserMapper.class);
        User user1 = sqlsession.selectOne("com.xing.dao.UserMapper.getUserById", 2);//书上看到新方法。
        System.out.println(user1.toString());
        System.out.println("我是书上的新方法！！！！！！");
        User user  = mapper.getUserById(1);
            System.out.println(user);
        //关闭sqlSession
        sqlsession.close();
    }
    //select * from mybatis.user where id = #{id}
    //类型处理器
    //select id,name,pwd as password from mybatis.user where id = #{id}

    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4j");
        logger.debug("debug：进入了testLog4j");
        logger.error("error:进入了testLog4j");

    }
}
