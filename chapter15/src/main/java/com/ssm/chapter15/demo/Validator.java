//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ssm.chapter15.demo;

import org.springframework.validation.Errors;

/**
 * 它只是一个校验器,在spring中最终被注册到验证器的列表中,这样就可以提供给各个控制器去定义,然后通过supports方法
 * 判定是否会启用验证器去验证数据,对于检验的过程,则是通过validate方法去实现的
 */
public interface Validator {
    /**
     * 判断当前验证器是否用于检验clazz类型的pojo
     * @param var1 pojo类型
     * @return true是启动检验,false则是不再检验
     */
    boolean supports(Class<?> var1);

    /**
     * 校验pojo的合法性
     * @param var1 pojo请求对象
     * @param var2 错误信息
     */
    void validate(Object var1, Errors var2);
}
