package com.imnu.mm.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//相当于web.xml
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	//Spring Ioc配置
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// 可以返回spring的java配置文件数组
		return new Class<?>[] {};
	}
	//DispatcherServlet的URl映射文件配置
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// 可以返回spring的java配置文件数组
		return new Class<?>[] {BeanConfig.class};
	}
	//DispatcherServlet拦截请求配置
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"*.action"};
	}
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig( // 通过重载customizeRegistration()方法配置multipart的具体
				new MultipartConfigElement("D:\\java_workspace", 500*1024*1024, 500*1024*1024, 0));
		//设置写入的临时路径
		//上传文件的最大容量（字节为单位），默认无限制
		//整个multipart请求的最大容量（字节为单位），默认无限制
		//在上传文件的过程中，如果文件达到了一个指定的最大容量，将会写入到临时文件路劲中。默认为0，也就是上传的文件都会写到磁盘中
	}
}
