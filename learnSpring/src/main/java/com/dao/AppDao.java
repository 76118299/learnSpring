package com.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

/**
 * 实现ApplicationContextAwar
 * 获取的都spring应用上下文
 */
@Repository
public class AppDao implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	public void get(){
		System.out.println("11111111");
		/***
		 * 获取一个原型对象
		 */
		applicationContext.getApplicationName();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			this.applicationContext = applicationContext;
	}
}
