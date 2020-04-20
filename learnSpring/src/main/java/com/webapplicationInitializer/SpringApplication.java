package com.webapplicationInitializer;

import com.config.Appconfig;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringApplication {

	public static  void  run(){
		Tomcat tomcat = new Tomcat();
		try {
			tomcat.setPort(6666);
			/**
			 * spring认为它不是web程序
			 * contextPath 表示tomcat的访问路径
			 * docBase 表示项目的web目录
			 */
			tomcat.addContext("/","d:/test");
			/**
			 * spring认为它是web程序 如果请求中包含 / 这回去 d:/test 中寻找index.html
			 */
			//tomcat.addWebapp("/","d:/test");
			//初始化spring
			AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
			ac.register(Appconfig.class);

			//ac.refresh();
			//初始化servlet dispatcherServlet 会调用 refresh（）方法初始化spring容器
			DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
			//加载servlet
			Wrapper mvc = tomcat.addServlet("/", "mvc", dispatcherServlet);
			//这个时候会调用DispathcerServlet的init()方法 初始化spring容器
			mvc.setLoadOnStartup(1);
			mvc.addMapping("*.do");

			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}
