package com.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 通过实现BeanPostProcessor
 * 可以对Bean进行修改 例如修改成代理对象、
 * 能够插手Bean的实例化
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
