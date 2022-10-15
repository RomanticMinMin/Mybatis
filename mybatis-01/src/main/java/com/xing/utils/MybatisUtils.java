package com.xing.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//sqlSessionFactory --> sqlSession
public class MybatisUtils {


    private static  SqlSessionFactory sqlSessionFactory;
    static{

        try {
            //使用mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            // SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStreamReader);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了SqlSessionFactory，顾名思义，我们就可以从中获得SqlSession的实例了。
    //SqlSession 完全包含了面向数据库执行SQL命令所需的所有方法。

public static SqlSession getSqlsession(){
//    SqlSession sqlSession = sqlSessionFactory.openSession();
//    return sqlSession; 也可简化如下：
    return sqlSessionFactory.openSession();

    }
}