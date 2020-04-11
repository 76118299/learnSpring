package com.app;

import com.config.Appconfig;
import com.dao.AppDao;
import com.testbeanfactorypostprocessor.TestBeanFactoryPosPorcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		//把spring 所有的前提环境准备好 包含 Bean工厂 , Bean 的容器 ，Bean的实例化
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Appconfig.class);
		/**
		 * 添加自定义的处理器
		 */
		context.addBeanFactoryPostProcessor(new TestBeanFactoryPosPorcessor());
		context.refresh();
		//getBean不需要调用refresh（）也可以得到Bean
		AppDao dao = context.getBean(AppDao.class);
		dao.get();



		AnnotationConfigApplicationContext context1 =
				new AnnotationConfigApplicationContext();
		context1.register(Appconfig.class);
		context1.scan("com");

	}
}
