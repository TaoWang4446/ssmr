//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ssm.chapter16.demo;

import org.springframework.core.convert.TypeDescriptor;

public interface ConditionalConverter {
    /**
     * 原数据类型,目标数据类型 如果返回true,才进行下一步转换
     * 有条件的转化器,当方法返回true,才进行转换, ConditionnalGenericConverter它是最常用的集合转换接口,首先它
     * 继承了 两个接口的方法,既能判断又能转换.
     *
     * spring core 开发了不少的实现类,这些实现类都会注册到ConverterService对象里,通过ConditionCoverter的matches进行匹配,
     * 如果可以匹配,则会调用convert方法进行转换,他能够提供各种对数组和集合的转换.
     *
     * @param var1
     * @param var2
     * @return
     */
    boolean matches(TypeDescriptor var1, TypeDescriptor var2);
}
