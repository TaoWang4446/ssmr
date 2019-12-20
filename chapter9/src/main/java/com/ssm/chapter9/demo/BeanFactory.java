/*
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ssm.chapter9.demo;

import org.springframework.beans.BeansException;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

*/
/**
 * ApplicaationContext就扩展了许多功能.
 * 先认识一下 ClassPathXmlApplicationContext 用来初始化 ioc容器
 *
 *
 *//*

public interface BeanFactory {
    String FACTORY_BEAN_PREFIX = "&";

    */
/**
     * 用于获取ioc中bean,
     * @param var1
     * @return
     * @throws BeansException
     *//*

    Object getBean(String var1) throws BeansException;

    <T> T getBean(String var1, Class<T> var2) throws BeansException;

    Object getBean(String var1, Object... var2) throws BeansException;

    <T> T getBean(Class<T> var1) throws BeansException;

    <T> T getBean(Class<T> var1, Object... var2) throws BeansException;

    <T> ObjectProvider<T> getBeanProvider(Class<T> var1);

    <T> ObjectProvider<T> getBeanProvider(ResolvableType var1);

    boolean containsBean(String var1);

    */
/**
     * 判断是否是单例
     * @param var1
     * @return
     * @throws NoSuchBeanDefinitionException
     *//*

    boolean isSingleton(String var1) throws NoSuchBeanDefinitionException;

    */
/**
     * 判断是否是原型
     * @param var1
     * @return
     * @throws NoSuchBeanDefinitionException
     *//*

    boolean isPrototype(String var1) throws NoSuchBeanDefinitionException;

    boolean isTypeMatch(String var1, ResolvableType var2) throws NoSuchBeanDefinitionException;

    boolean isTypeMatch(String var1, Class<?> var2) throws NoSuchBeanDefinitionException;

    @Nullable
    */
/**
     * 按java类型匹配的方式
     *//*

    Class<?> getType(String var1) throws NoSuchBeanDefinitionException;

    */
/**
     * 获取别名的方法
     * @param var1
     * @return
     *//*

    String[] getAliases(String var1);
}
*/
