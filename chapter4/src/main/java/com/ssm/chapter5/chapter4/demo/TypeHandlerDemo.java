package com.ssm.chapter5.chapter4.demo;

import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeHandlerDemo {
    public interface TypeHandler<T/*泛型*/> {//专指javaType,比如需要String的时候,实现类可以写为 implements TypeHandler<String>

        /**
         * 是使用typeHandler通过PreparedStatement对象进行设置sql参数的时候使用的具体方法,
         * @param ps
         * @param i 是参数在sql下的下标,
         * @param parameter 参数
         * @param jdbcType 数据库类型
         * @throws SQLException
         */
        void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

        /**
         * 从jdbc结果集中获取数据进行转换,要么使用别名,要么使用下标获取数据库的数据,
         * @param rs
         * @param columnName
         * @return
         * @throws SQLException
         */
        T getResult(ResultSet rs, String columnName) throws SQLException;

        T getResult(ResultSet rs, int columnIndex) throws SQLException;

        /**
         * 存储过程专用
         * @param cs
         * @param columnIndex
         * @return
         * @throws SQLException
         */
        T getResult(CallableStatement cs, int columnIndex) throws SQLException;

    }
}
