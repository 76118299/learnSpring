package com.testbeanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 *可以对BeanDefinition进行修改
 */
public class TestBeanFactoryPosPorcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		/**
		 * 通过实现BeanFaoctoryPostProcessor 来修改BeanDefiniton 修改Bean的描述；
		 */
		BeanDefinition appDao = beanFactory.getBeanDefinition("AppDao");
		appDao.setScope("prototype");

		GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("aa");
		genericBeanDefinition.setAutowireMode(2); //将主人模型 修改成根据type进行注入。

	}
}
