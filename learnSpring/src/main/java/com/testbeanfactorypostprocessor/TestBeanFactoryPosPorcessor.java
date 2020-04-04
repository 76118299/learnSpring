package com.testbeanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 *
 */
public class TestBeanFactoryPosPorcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		/**
		 * 通过实现BeanFaoctoryPostProcessor 来修改BeanDefiniton 修改Bean的描述；
		 */
		BeanDefinition appDao = beanFactory.getBeanDefinition("AppDao");
		appDao.setScope("prototype");

	}
}
