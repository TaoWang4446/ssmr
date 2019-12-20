package com.wst.chapter2.responsibility;

public class TestInterceptor {
	public static void main(String[] args) {
		//testInterceptor();
		testChain();
	}
	
	
	public static void testInterceptor() {
		HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), 
				"com.wst.chapter2.responsibility.MyInterceptor");
		proxy.sayHelloWorld();
	}
	
	public static void testChain() {
		HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(
                new HelloWorldImpl(), "com.wst.chapter2.responsibility.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(
                proxy1, "com.wst.chapter2.responsibility.Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(
                proxy2, "com.wst.chapter2.responsibility.Interceptor3");
        proxy3.sayHelloWorld();
	}
}
