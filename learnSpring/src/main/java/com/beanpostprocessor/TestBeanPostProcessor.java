package com.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * BeanPostPorcessor Bean的后置处理器
 * PriorityOrdered 定义类的初始化顺序
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {
	/**
	 * 在Bean 初始化之前执行
	 * @param bean 原始的Bena
	 * @param beanName Bean的名称
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//在这里可以对Bean 进行动态代理
		//Proxy.newProxyInstance()
		return bean;
	}

	/**
	 * Bean初始化之后
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
