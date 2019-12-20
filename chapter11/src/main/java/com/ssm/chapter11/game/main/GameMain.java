package com.ssm.chapter11.game.main;

import com.ssm.chapter11.game.Interceptor;
import com.ssm.chapter11.game.ProxyBeanFactory;
import com.ssm.chapter11.game.interceptor.RoleInterceptor;
import com.ssm.chapter11.game.pojo.Role;
import com.ssm.chapter11.game.service.RoleService;
import com.ssm.chapter11.game.service.impl.RoleServiceImpl;

public class GameMain {
    public static void main(String[] args) {
        RoleService roleService = new RoleServiceImpl();
        Interceptor interceptor = new RoleInterceptor();

        RoleService proxy = ProxyBeanFactory.getBean(roleService,interceptor);

        Role role =new Role();
        role.setId(1L);
        role.setRoleName("wst");
        role.setNote("note");

        proxy.printRole(role);

        System.out.println("-----------------------------------");

        role = null;

        proxy.printRole(role);
    }
}
