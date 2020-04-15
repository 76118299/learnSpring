package com.webapplicationInitializer;

import com.config.Appconfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
		//初始化spring环境
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		//加载配置类
		ac.register(Appconfig.class);
		//刷新容器
		ac.refresh();
		//注册servlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		registration.setLoadOnStartup(1);
		//拦截所有请求
		registration.addMapping("/");




	}
}
