package com.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SqlSessionFactoryUtils {

	private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

	private static SqlSessionFactory sqlSessionFactory = null;

	private SqlSessionFactoryUtils() {
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		synchronized (LOCK) {
			if (sqlSessionFactory != null) {
				return sqlSessionFactory;
			}
			String resource = "mybatis-config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				/**
				 * 采用SqlSessionFactoryBuilder去构建.
				 * 1.XMLConfigBuilder:解析配置文件,读取所需配置的参数,并将读取的内容存入Configuration对象中,而Configuration
				 * 采用的是单例模式,几乎所有的mybatis配置内容都会放到这个单例对象中,以便后续将这些内容读取.
				 * 2.使用Configuration对象去创建SqlSessionFactory,SqlSessionFactory是一个接口,mybatis提供了一个DefaultSqlSessionFactory
				 *
				 * 这种创建方式是 构建者模式 ,对于复杂的对象而言,使用构造参数难实现.这是用一个类(比如Configuration)作为统领,
				 * 一步步的构建所需要的内容,然后通过它去创建最终的对象(比如SqlSessionFactory),这样每一步都很清晰.
				 */
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				/**
				 * mybatis会根据文件流生成Configuration对象,进而去构建SqlSessionFactory对象,
				 * 难点是构建Configuration对象,
				 */
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			return sqlSessionFactory;
		}
	}
	
	
	public static SqlSession openSqlSession() {
		if (sqlSessionFactory == null) {
			getSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	}
}