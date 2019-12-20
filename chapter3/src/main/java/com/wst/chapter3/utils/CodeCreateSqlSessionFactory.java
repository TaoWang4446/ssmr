package com.wst.chapter3.utils;

import com.wst.chapter3.mapper.RoleMapper;
import com.wst.chapter3.pojo.Role;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class CodeCreateSqlSessionFactory {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        //sqlSession只是一个门面接口,有很多方法,可以直接发送sql,像软件公司的一个商务人员,是一个门面,实际干活是软件工程师.mybatis中真正干活的是Exceutor.

        //sqlSession控制数据库事务的方法
        try {
            sqlSession = sqlSessionFactory.openSession();
            //some code
            //SqlSession发送sql
            Role role = sqlSession.selectOne("com.wst.chapter3.mapper.RoleMapper.getRole",1L);
            Role role1 = sqlSession.selectOne("getRole",1L);

            //用Mapper接口来发送sql
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role2 = roleMapper.getRole(1l);
            //selectOne()查询且返回一个对象.参数是一个String对象和一个Object对象.
            //
            sqlSession.commit();//提交事务
            //一个数据库的连接资源用完要关闭.
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        //数据库连接池信息
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ssm");
        dataSource.setDefaultAutoCommit(false);
        //采用mybatis的jdbc事物方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development",transactionFactory,dataSource);

        //创建 Configuration对象
        Configuration configuration = new Configuration(environment);
        //注册一个mybatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
        //加入一个映射器
        configuration.addMapper(RoleMapper.class);

        //使用SqlSessionFactoryBuilder构建SessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }


}
