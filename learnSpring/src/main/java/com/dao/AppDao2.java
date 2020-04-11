package com.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * aop 动态代理
 */
public class AppDao2 implements Dao  {

	@Override
	public String query() {
		return null;
	}
}
