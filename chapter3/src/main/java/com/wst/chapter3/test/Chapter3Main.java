package com.wst.chapter3.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.wst.chapter3.mapper.RoleMapper;
import com.wst.chapter3.mapper.RoleMapper2;
import com.wst.chapter3.pojo.Role;
import com.wst.chapter3.utils.SqlSessionFactoryUtils;
public class Chapter3Main {

	public static void main(String[] args) {
		testRoleMapper();
		testRoleMapper2();
		
	}
	
	
	private static void testRoleMapper() {
		Logger log = Logger.getLogger(Chapter3Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			log.info(role.getRoleName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	//注解SQL测试
	private static void testRoleMapper2() {
		Logger log = Logger.getLogger(Chapter3Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
			Role role = roleMapper2.getRole(1L);
			log.info(role.getRoleName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
}