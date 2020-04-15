package com.myimportdefinitionregistrar;

import com.dao.AppDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * FacotryBean 接口会注册2个对象一个是它自己
 * 一个是getObject返回的对象
 * 可以使用@Componetn
 * 也可使用ImportBeanDefintinoRegistrar
 */
//@Component
public class MyFactoryBean implements FactoryBean,InvocationHandler {
	public MyFactoryBean(Class clazz) {
		this.clazz = clazz;
	}
	private Class clazz;

	@Override
	public Object getObject() throws Exception {
		Object appDaoProxy =  Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
		return appDaoProxy;
	}

	@Override
	public Class<?> getObjectType() {
		return AppDao.class;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy");
		return null;
	}


}
