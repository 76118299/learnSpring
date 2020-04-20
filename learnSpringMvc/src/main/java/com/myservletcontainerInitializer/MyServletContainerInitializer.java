package com.myservletcontainerInitializer;

import com.servlet.MySerlvet;
import com.webapplicationinitializer.MyWebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;
@HandlesTypes(MyWebApplicationInitializer.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		ServletRegistration.Dynamic registration = ctx.addServlet("xx", new MySerlvet());
		registration.addMapping("/");
	}
}
