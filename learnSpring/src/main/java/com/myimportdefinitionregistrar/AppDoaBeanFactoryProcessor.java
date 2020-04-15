package com.myimportdefinitionregistrar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 这里实现通过构造方法注入一个Class 对象
 */
@Component
public class AppDoaBeanFactoryProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
	 GenericBeanDefinition genericBeanDefinition= (GenericBeanDefinition) beanFactory.getBeanDefinition("indexDao");
		/**
		 * 构造方法的值
		 */
		genericBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.index2Dao");

	}
}
