package com.imnu.mm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//相当于web.xml
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	//加载spring IOC 配置
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{};
	}
	//加载Bean
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{BeanConfig.class};
	}
	//DispatcherServlet拦截请求配置
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"*.action"};
	}

}
