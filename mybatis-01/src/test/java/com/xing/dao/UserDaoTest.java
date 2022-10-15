package com.xing.dao;

import com.xing.pojo.User;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象

        SqlSession sqlsession = MybatisUtils.getSqlsession();


        //执行SQL
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println("第一次遍历！！");
        UserDao userDao = sqlsession.getMapper(UserDao.class);
        List<User> userlist = userDao.getUserList();

        for (User user : userlist) {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlsession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();

        UserDao userDao = sqlsession.getMapper(UserDao.class);
        User user = userDao.getUserById(3);
        System.out.println(user);

        sqlsession.close();

    }

    @Test
    //增删改需要提交事务
    public void  addUser(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserDao userDao = sqlsession.getMapper(UserDao.class);

        int res = userDao.addUser(new User(5, "附件附件", "1888345"));
        if(res>0){
            System.out.println("插入成功！"+res+"条！");
        }

        //提交事务
        sqlsession.commit();

        //关闭事务
        sqlsession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();

        UserDao mapper = sqlsession.getMapper(UserDao.class);
        mapper.updateUser(new User(4,"呵呵","123123"));

        //提交事务
        sqlsession.commit();

        //关闭事务
        sqlsession.close();
    }


    @Test
    public void deleteUser(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();

        UserDao mapper = sqlsession.getMapper(UserDao.class);

        mapper.deleteUser(4);


        sqlsession.commit();
        sqlsession.close();
    }
}
