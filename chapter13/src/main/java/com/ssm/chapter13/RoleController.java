package com.ssm.chapter13;

import com.ssm.chapter13.pojo.Role;
import com.ssm.chapter13.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 两个insert方法根本不在同一个事务里。
     * 如果service上标有事务注解，那么他就会启用一个事务，一个service方法完成后，就会释放事务，前后两个
     * 的插入操作是不在一个事务中完成的。如果下一个事务发生异常回滚，就会造成数据不一致问题。
     */
    public void errUserService(){
        Role role = new Role();
        role.setRoleName("wst");
        roleService.insertRole(role);

        Role role1 = new Role();
        role1.setRoleName("swt");
        roleService.insertRole(role1);

    }
}
