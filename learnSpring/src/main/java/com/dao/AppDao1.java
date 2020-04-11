package com.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * aop 动态代理
 * 这是spring和aop进行结合的地方
 * 实现BeanPostProcessor
 */
public class AppDao1 implements BeanPostProcessor,InvocationHandler  {


	/**
	 * 将Bean修改成代理对象
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("appDao")){
			 bean= Proxy.newProxyInstance(AppDao2.class.getClassLoader(),new Class[]{AppDao2.class},this);
		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是代理对象");
		return null;
	}
}
