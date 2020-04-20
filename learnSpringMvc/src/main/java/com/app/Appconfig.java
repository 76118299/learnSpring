package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletContainerInitializer;

@Configuration
public class Appconfig  implements WebMvcConfigurer {

	/**
	 * 配置视图解析器
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver  internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/");
		internalResourceViewResolver.setSuffix(".jsp");
		return  internalResourceViewResolver;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/",".jsp");
	}
}
