package com.ssm.chapter9.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.chapter9.pojo.JuiceMaker;
import com.ssm.chapter9.pojo.JuiceMaker2;

public class Chapter9Main {
	public static void main(String[] args) {
		testIoC();
	}
	
	public static void testCommon() {
		JuiceMaker juiceMaker = new JuiceMaker();
		juiceMaker.setWater("矿泉水");
		juiceMaker.setFruit("橙子");
		juiceMaker.setSugar("少糖");
		System.out.println(juiceMaker.makeJuice());
	}
	
	public static void testIoC() {
		/**
		 * spring的初始化和依赖注入
		 * 	先定义
		 * 	然后初始化和依赖注入
		 *
		 * 	bean的定义分
		 * 	1.Resource定位,ioc根据配置,进行资源定位
		 * 	2.BeanDefinition 的载入,将resource定位到的消息,保存到bean定义中,此时并不会创建bean的实例.
		 * 	3.BeanDefinition 的注册,就是将BeanDefinition的信息发布到spring ioc容器中,此时还没有对应bean的实例创建.
		 *
		 * 	完成以上3步,bean就在ioc容器中被定义了,而没有初始化,更没有完成依赖注入,也就是没有注入其配置的资源给bean,
		 * 	那么还不能使用.默认的配置选项是false,spring在默认情况下会自动初始化备案,如果true,getBean()时,才会初始化,完成依赖注入
		 *
		 */

		/*AnnotationConfigApplicationContext去初始化 ioc容器*/
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-cfg.xml");
		JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctx.getBean("juiceMaker2");
		System.out.println(juiceMaker2.makeJuice());
		ctx.close();
	}
}
