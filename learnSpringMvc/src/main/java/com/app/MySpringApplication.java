package com.app;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * 知识点2 通过代码启动tomcat 由于是java项目没有webapp目录 所以需要将html放入classpath
 * 所以再请求servlet的时候需要用文件流输出给浏览器
 * 还要手动添加serlvet 。需要实现serletContainerInitialzier 的onStartUP方法 添加servlet
 *
 * public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
 * 		ServletRegistration.Dynamic registration = ctx.addServlet("xx", new MySerlvet());
 * 		registration.addMapping("/");
 *        }
 *
 * servlet中通过文件流输出html
 * springboot 它没有webapp的目录
 */
public class MySpringApplication {
	public static void  run() throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(6000);
		String relativelyPath = System.getProperty("user.dir");
		//获取当前项目的路径
		String sourcePath = MySpringApplication.class.getResource("/").getPath();
		String webDirLocaton = relativelyPath + "src/main/webapp/";
		//告诉tomcatwebapp的工作的目录 但是由于springboot是一个java项目所有 指定webapp目录没有用
	   StandardContext context= (StandardContext) tomcat.addWebapp("/",new File(webDirLocaton).getAbsolutePath());
	   WebResourceRoot resources = new StandardRoot(context);
	   //告诉tomcatclass文件所在的位置
	   resources.addPreResources(new DirResourceSet(resources,"/WEB-INF/classes",sourcePath,"/"));
	   context.setResources(resources);
		tomcat.start();
		tomcat.getServer().await();

		/**
		 * addWebapp表示当前项目是一个web项目
		 * contextPath  第一个参数 “/” tomcat的访问路径
		 * docBase 第二个参数 项目的web目录 index.html
		 */
		tomcat.addWebapp("/","src/main/webapp");

//		String path = MySpringApplication.class.getResource("/").getPath();
//		//告诉tomcat源码再哪里
//		Context context = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
//		WebResourceRoot resources = new StandardRoot(context);
//		resources.addPreResources(new DirResourceSet(resources,"/WEB-INF/classes",path,"/"));
//		context.setResources(resources);
//
//		tomcat.start();
//		tomcat.getServer().await();
	}
}
