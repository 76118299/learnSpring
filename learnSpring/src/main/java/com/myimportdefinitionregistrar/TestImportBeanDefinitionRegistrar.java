package com.myimportdefinitionregistrar;

import com.dao.AppDao;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 可以动态的添加一个BeanDefinitino
 */
public class TestImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//1.得到BD
		//扫描所有接口 得到接口的路径获取class对象
		//创建代理对象
		//这里不可以用代理对象的class 的用BeanFacotryPostPorcessor 将BD 继续修改成代理对象
		//AppDao appDaoProxy = (AppDao) Proxy.newProxyInstance(AppDao.class.getClassLoader(), new Class[]{AppDao.class}, new myInvocationHandler());
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(AppDao.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
		/**
		 * 这里BD添加一个构造函数
		 * 传给FacooryBean 构造方法参数  appDao的Calss spring会根据这个名字找到对应的class  进行传递
		 */
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("appDao");
		/**
		 * 这里面放入FacotryBean class  会返回 FacotryBean 接口中getObject（）的返回值
		 */
		beanDefinition.setBeanClass(MyFactoryBean.class);

		//2.注册BD
		registry.registerBeanDefinition("appDao",beanDefinition);

	}


}
