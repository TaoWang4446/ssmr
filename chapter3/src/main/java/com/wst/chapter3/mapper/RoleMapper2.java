package com.wst.chapter3.mapper;

import com.wst.chapter3.pojo.Role;
import org.apache.ibatis.annotations.Select;


public interface RoleMapper2 {
	/**
	 * 注解方式 对于复杂的sql编写 代码可读性下降.xml 可以使用更多的标签,对于一些简单的配置用注解.
	 * @param id
	 * @return
	 */
	
	@Select("select id, role_name as roleName, note from t_role where id=#{id}")
	public Role getRole(Long id);
}
