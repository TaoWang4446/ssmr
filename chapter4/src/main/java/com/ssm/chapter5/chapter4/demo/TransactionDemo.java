package com.ssm.chapter5.chapter4.demo;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 从方法可知:主要工作是提交 回滚 和关闭 数据库的事务.
 * 有两个实现类在mybatis中:JdbcTransaction  ManagedTransaction 对应着两种工厂 JdbcTransactionFactory  ManagedTransactionFactory
 * 这个工厂需要实现TransactionFactory接口,通过他们会生成对应的Transaction对象.
 * 于是可以把事务管理配置成两种方式
 * <transactionManager type="JDBC"/><!--事务管理器-->
 *     他使用JdbcTransactionFactory生成的JdbcTransaction对象实现,以jdbc的方式对数据库的提交和回滚进行操作.
 * <transactionManager type="MANAGED"/><!--事务管理器-->
 *     他使用ManagedTransactionFactory生成的ManagedTransaction对象实现,他的提交和回滚方法不用任何操作,而是把事务交给容器处理.默认情况下
 *     它会关闭连接,然而一些容器不希望这样,因此将closeConnection 属性设置为 false来阻止它默认的关闭行为.
 *
 *     不想采用mybatis的规则时,自己定义一个事务工厂.
 *     <transactionManager type="com.xxx.xxx.MyTransactionFactory" />
 */
public interface TransactionDemo {
    /**
     * Retrieve inner database connection
     * @return DataBase connection
     * @throws SQLException
     */
    Connection getConnection() throws SQLException;

    /**
     * Commit inner database connection.
     * @throws SQLException
     */
    void commit() throws SQLException;

    /**
     * Rollback inner database connection.
     * @throws SQLException
     */
    void rollback() throws SQLException;

    /**
     * Close inner database connection.
     * @throws SQLException
     */
    void close() throws SQLException;

    /**
     * Get transaction timeout if set
     * @throws SQLException
     */
    Integer getTimeout() throws SQLException;
}
