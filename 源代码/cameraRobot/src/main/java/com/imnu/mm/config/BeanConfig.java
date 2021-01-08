package com.imnu.mm.config;

import java.io.IOException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.druid.pool.DruidDataSource;

//读取配置文件相当于xml
@Configuration
//扫描基础包
@ComponentScan("com.imnu.mm")
//开启mvc配置文件
@EnableWebMvc
//开启事务
@EnableTransactionManagement
//读取property文件
@PropertySource("classpath:application.properties")
//扫描mapper包
@MapperScan("com.imnu.mm.mapper")
public class BeanConfig {
	@Value("${jdbc.driver}")
	private String classdriver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${mybatis.mapperLocations}")
	private String mapperLocations;
	@Value("${mybatis.typeAliasesPackage}")
	private String typeAliasesPackage;
	@Value("${mybatis.mapperBasePackage}")
	private String mapperBasePackage;
	//DataSource
		@Bean
		public DataSource getDataSource() {
			DruidDataSource druidDataSource = new DruidDataSource();
			druidDataSource.setDriverClassName(classdriver);
			druidDataSource.setUrl(url);
			druidDataSource.setUsername(username);
			druidDataSource.setPassword(password);
			return druidDataSource;
		}
		//SqlSessionFactoryBean
		@Bean
		public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			//获取mapper映射文件的路径
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			Resource[] resources = null;
			try {
				resources = resolver.getResources(mapperLocations);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sqlSessionFactoryBean.setMapperLocations(resources);
			sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
			
			return sqlSessionFactoryBean;
		}
	//事务
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	//视图解析器
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	//文件上传
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
}
