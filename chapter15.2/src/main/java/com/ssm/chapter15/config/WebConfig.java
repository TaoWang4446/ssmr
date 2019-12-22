package com.ssm.chapter15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.ssm.chapter15"})
@EnableWebMvc
public class WebConfig {

	/**
	 * name = "multipartResolver"是spring约定好的,不能修改,有时候需要对文件大小进行设置,比如限制单个文件的大小,设置上传
	 * 文件的路径,这些都是常见的配置
	 * 长的类的 只需要继承就可以了
	 *
	 * @return
	 */
	@Bean(name = "multipartResolver")
	/**
	 * MultipartResolver 对于文件上传解析器,
	 * springmvc中 对于它的调用是通过前端控制器进行的
	 * 首先判断,请是否是一种enctype="multipart/*"的的请求,
	 * 如果是并且存在一个名词为multipartResolver的bean定义,那它将会把HTTPServletRequest请求转换为 MultipartHttpServletRequest 请求对象.
	 * MultipartHttpServletRequest是一个springmvc自定义的接口,它扩展了HTTPServletRequest和关于文件的操作接口MultipartRequest.
	 *
	 * 同样的,实现MultipartHttpServletRequest接口的是一个抽象类,它就是AbstractMultipartHttpServletRequest,它提供了一个公共的实现
	 * 在这个类的基础上,MultipartResolver的不同,派生出DefaultMultipartHttpServletRequest和 StandardMultipartHttpServletRequest

	 * 代表这可以根据实现方式的不同进行选择.
	 *
	 * *
	 * 	 * MultipartHttpServletRequest 具备了原来 HttpServletRequest对象的操作能力,还具备了文件的操作能力,对于文件的操作持有的资源
	 * 	 * 到最后前端控制器会释放对应的资源,它还会把文件请求转换为一个MultipartFile对象,通过这个对象就可以进一步操作文件了,这样对文件上传的开发就只需要关心其方法了.
	 *
	 */
	public MultipartResolver initMultipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	/**
	 * 如果spring 或者 servlet版本过低的时候,用一下配置.
	@Bean(name = "multipartResolver")
	public MultipartResolver initCommonsMultipartResolver() {
		//文件上传路径
		String filepath = "e:/mvc/uploads";
		//5MB
		Long singleMax = (long) (5 * Math.pow(2, 20));
		//10MB
		Long totalMax = (long) (10 * Math.pow(2, 20));
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSizePerFile(singleMax);
		multipartResolver.setMaxUploadSize(totalMax);
		try {
			multipartResolver.setUploadTempDir(new FileSystemResource(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return multipartResolver;
	}
	*/
}
