package com.wst.chapter3.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = null;
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try{
            /**
             * 首先读取配置文件,然后通过SqlSessionFactoryBuilder.build()去创建sqlSessionFactory,整个过程是看到时简单,内部繁琐,采用了Builder模式隐藏了实现细节.
             */
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
