package com.ssm.chapter7.main;

import java.util.ArrayList;
import java.util.List;

import com.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import com.ssm.chapter7.mapper.RoleMapper;
import com.ssm.chapter7.pojo.Role;

/**
 * 本章目标:
 * 1.了解mybatis解析配置文件的过程
 * 2.掌握mybatis底层映射保存的数据结构(MappedStatemtn, sqlSource BoundSql)及其内容
 * 3.了解mybatis的 Mapper的运行原理
 * 4.掌握SqlSession的运行原理
 * 5.掌握SqlSession下四大对象的设计原理与具体方法的作用
 *
 * 运行过程分为两步:
 * 	1.读取配置文件缓存到Configuration对象,用以创建SqlSessionFactory
 * 	2.SqlSession的执行过程.
 */
public class Chapter7Main {

	public static void main(String[] args) {
		testFindRole1();
//		testFindRole2();


//		testFindRole3();
//		testFindRole4();
//		testFindRole5();
//		testFindRole6();
//		testUpdateRole();
//		testFindRoleByNums();
//		testGetRoleTest();
	}

	public static void testFindRole1() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			//sqlSession.getMapper(RoleMapper.class);
			/**
			 *<T> T getMapper(Class<T> type);
			 *
			 * DefaultSqlSession.
			 * public <T> T getMapper(Class<T> type) {
			 *     return configuration.<T>getMapper(type, this);
			 *   }
			 *
			 *   public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
			 *     return mapperRegistry.getMapper(type, sqlSession);
			 *   }
			 *
			 *   protected final MapperRegistry mapperRegistry = new MapperRegistry(this);
			 *
			 *    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
			 *     final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
			 *     if (mapperProxyFactory == null) {//先判断是否注册一个Mapper,如果没有就抛异常
			 *       throw new BindingException("Type " + type + " is not known to the MapperRegistry.");
			 *     }
			 *     try {//如果有就启用MapperProxyFactory工厂来生成一个代理实例
			 *       return mapperProxyFactory.newInstance(sqlSession);
			 *     } catch (Exception e) {
			 *       throw new BindingException("Error getting mapper instance. Cause: " + e, e);
			 *     }
			 *   }
			 *
			 *   MapperProxyFactory<T>
			 *       Mapper映射是通过动态代理来实现的,这里可以看到动态代理对接口的绑定,他的作用就是生成
			 *       动态代理对象(占位),而代理的方法则被放到了MapperProxy类中.
			 *   @SuppressWarnings("unchecked")
			 *   protected T newInstance(MapperProxy<T> mapperProxy) {
			 *     return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
			 *   }
			 *
			 *   public T newInstance(SqlSession sqlSession) {
			 *     final MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, mapperInterface, methodCache);
			 *     return newInstance(mapperProxy);
			 *   }
			 *
			 *
			 *   @Override
			 *   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			 *     try {//如果Mapper是一个jdk动态代理对象,那就会运行到invoke方法中
			 *     首先判断是否是一个类,这里Mapper是一个接口,不是类,所以判断失败
			 *     然后生成MapperMethod对象,是通过CacheMapperMethod方法对其初始化的.
			 *     最后执行execute方法,
			 *     把SQLSession和当前运行的参数穿进去
			 *       if (Object.class.equals(method.getDeclaringClass())) {
			 *         return method.invoke(this, args);
			 *       } else if (isDefaultMethod(method)) {
			 *         return invokeDefaultMethod(proxy, method, args);
			 *       }
			 *     } catch (Throwable t) {
			 *       throw ExceptionUtil.unwrapThrowable(t);
			 *     }
			 *     final MapperMethod mapperMethod = cachedMapperMethod(method);
			 *     return mapperMethod.execute(sqlSession, args);
			 *   }
			 *
			 *   MapperMethod类采用命令行模式运行,根据上下文跳转可能跳转到许多方法中,
			 *   实际上他最后是通过sqlSesion对象去运行对象的sql而已,其他的curd也是类似处理的
			 *    public Object execute(SqlSession sqlSession, Object[] args) {
			 *     Object result;
			 *     switch (command.getType()) {
			 *       case INSERT: {
			 *       Object param = method.convertArgsToSqlCommandParam(args);
			 *         result = rowCountResult(sqlSession.insert(command.getName(), param));
			 *         break;
			 *       }
			 *       case UPDATE: {
			 *         Object param = method.convertArgsToSqlCommandParam(args);
			 *         result = rowCountResult(sqlSession.update(command.getName(), param));
			 *         break;
			 *       }
			 *       case DELETE: {
			 *         Object param = method.convertArgsToSqlCommandParam(args);
			 *         result = rowCountResult(sqlSession.delete(command.getName(), param));
			 *         break;
			 *       }
			 *       case SELECT:
			 *         if (method.returnsVoid() && method.hasResultHandler()) {
			 *           executeWithResultHandler(sqlSession, args);
			 *           result = null;
			 *         } else if (method.returnsMany()) {
			 *           result = executeForMany(sqlSession, args);
			 *         } else if (method.returnsMap()) {
			 *           result = executeForMap(sqlSession, args);
			 *         } else if (method.returnsCursor()) {
			 *           result = executeForCursor(sqlSession, args);
			 *         } else {
			 *           Object param = method.convertArgsToSqlCommandParam(args);
			 *           result = sqlSession.selectOne(command.getName(), param);
			 *         }
			 *         break;
			 *       case FLUSH:
			 *         result = sqlSession.flushStatements();
			 *         break;
			 *       default:
			 *         throw new BindingException("Unknown execution method for: " + command.getName());
			 *     }
			 *     if (result == null && method.getReturnType().isPrimitive() && !method.returnsVoid()) {
			 *       throw new BindingException("Mapper method '" + command.getName()
			 *           + " attempted to return null from a method with a primitive return type (" + method.getReturnType() + ").");
			 *     }
			 *     return result;
			 *   }
			 *
			 *   为什么只用Mapper就能运行:
			 *   Mapper的xml文件的命名空间对应的是这个接口的全限定名,而方法就是sql的id,这样mybatis就可以根据全限定名+id,将其和
			 *   代理对象绑定起来
			 *   通过动态代理技术,让这个接口就可以运行起来,而后采用命令模式
			 *   最后 使用SqlSession接口的方法使得他能够执行对应的ql,只是有了这层封装,就可以采用接口编程,这样的接口编程
			 *   更为简单明了.
			 *
			 *
			 *   总结:
			 *   sqlSession.getMapper():
			 *   	用到了Configuration.getMapper()
			 *   		用到了MapperRegistry.getMapper()[映射器的注册器来获取对应的接口,首先判断是否注册,有就会
			 *   			启用MapperProxyFactory来生成一个代理实例, MapperProxyFactory.newInstance() mapperProxy]
			 *   				mapperProxy中有代理的方法 invoke() 生成 MapperMethod对象
			 *   					最后执行exectue(sqlSession)
			 */

			/**
			 * 映射器是一个动态代理对进入到MapperMethod的execute(),然后它经过简单判断就进入到SqlSesion 的 curd等方法,
			 * 那么这些方法是如何执行的呢?
			 * 根据全类名和方法名就可以配置到配置的sql
			 * 实际上SqlSession 的执行过程是通过
			 * Execute :执行器,由他调度:StatementHandler parameterHandler  ResultSetHandler来执行对应的sql
			 * StatementHandler:作用,使用数据库的Statement(PrarentStatement)执行操作,是死的对象的核心,承上启下,许多插件都是
			 * 	通过拦截它来实现的
			 * parameterHandler :用来处理sql参数
			 * ResultSetHandler :是进行数据集的封装 返回处理的.
			 * 来完成的.
			 *
			 */
			List<Role> roleList = roleMapper.findRole1("role_name");
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public static void testFindRole2() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setRoleNo("role_no_1");
			role.setRoleName("role_name");
			List<Role> roleList = roleMapper.findRole2(role);
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public static void testFindRole3() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setRoleNo("role_no_1");
			role.setRoleName("role_name");
			List<Role> roleList = roleMapper.findRole3(role);
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public static void testFindRole4() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roleList = roleMapper.findRole4("role_name");
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public static void testFindRole5() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roleList = roleMapper.findRole5("role_name");
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public static void testFindRole6() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roleList = roleMapper.findRole6("role_name", "note");
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	public static void testUpdateRole() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setNote("note_1_update");
			role.setRoleName("role_name_1_update");
			role.setRoleNo("role_no_1");
			int result = roleMapper.updateRole(role);
			System.out.println(result);
			sqlSession.commit();
		} catch(Exception ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	public static void testFindRoleByNums() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<String> roleNoList = new ArrayList<String>();
			roleNoList.add("role_no_1");
			roleNoList.add("role_no_2");
			roleNoList.add("role_no_3");
			List<Role> roleList = roleMapper.findRoleByNums(roleNoList);
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public static void testGetRoleTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roleList = roleMapper.getRoleTest("Y");
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}