package com.ssm.chapter11.game;

/**
 * 这是一个拦截接口,可以对它创建实现类,
 * 要求读者生成对象的时候,都用这样的一个类去生成对应的对象.
 */
public interface Interceptor {
	
	public void before(Object obj);

    public void after(Object obj);

    public void afterReturning(Object obj);

    public void afterThrowing(Object obj);
}
