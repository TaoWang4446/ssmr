package com.ssm.chapter11.game;

/**
 *要求读者生成对象的时候,都用这样的一个类去生成对应的对象.
 *  */
public class ProxyBeanFactory {
    /**
     * 使用了这个方法以后,存在如下的约定:
     * 1.bean必须是一个实现了某一个接口的类
     * 2.最先会执行拦截器的before方法
     * 3.其次执行bean的方法(通过反射的形式)
     * 4.执行bean的方法时,无论是否发生异常,都会执行after方法
     * 5.执行bean的方法时,如果不产生异常,则执行afterRetuning方法;如果产生异常,则执行afterThrowing方法
     *
     * 这个约定已经接近aop对我们的约定了.
     *
     * @param obj
     * @param interceptor
     * @param <T>
     * @return
     */
	public static <T> T getBean(T  obj, Interceptor interceptor) {
        return (T) ProxyBeanUtil.getBean(obj, interceptor);
    }
}
