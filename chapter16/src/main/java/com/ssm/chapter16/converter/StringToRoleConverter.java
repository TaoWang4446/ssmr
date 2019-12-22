package com.ssm.chapter16.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.ssm.chapter16.pojo.Role;

/**
 * 字符串跟角色的转换类
 * 通过HttpMessageConverter把HTTP请求消息读出后,springmvc就开始使用这些转换器来将HTTP的消息,转化为控制器的参数,
 * 这就是能在控制器上获得各类参数的原因.
 *
 * 只要实现接口Converter,然后注册给对应的转换服务类即可.实现自已的转换器
 *
 *
 */
public class StringToRoleConverter implements Converter<String, Role> {

    @Override
    public Role convert(String str) {
        //空串
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        //不包含指定字符
        if (str.indexOf("-") == -1) {
            return null;
        }
        String[] arr = str.split("-");
        //字符串长度不对
        if (arr.length != 3) {
            return null;
        }
        Role role = new Role();
        role.setId(Long.parseLong(arr[0]));
        role.setRoleName(arr[1]);
        role.setNote(arr[2]);
        return role;
    }

}
