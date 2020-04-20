package com.webapplicationinitializer;

import com.app.Appconfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 知识点1
 * tomcat启动的时候会通过spi机制 调用ServletContainerInitalizer
 * ServletContainerInitalizer 的实现类会onStartup方法调用WebApplicationInitializer的实现类
 *
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		/**
		 * 初始化spring容器
		 */
		AnnotationConfigWebApplicationContext ac=new AnnotationConfigWebApplicationContext();
		//加载配置类
		ac.register(Appconfig.class);
		//加载DispathcerServlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");

	}
}
