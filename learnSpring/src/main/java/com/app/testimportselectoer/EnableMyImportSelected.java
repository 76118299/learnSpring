package com.app.testimportselectoer;


import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义注解 做成一个aop的开关
 */
@Retention(RetentionPolicy.RUNTIME)
//引入ImportSelector的实现类 ，ImporetSelecter 实现类会添加一个BenaPsotProcessor 后置处理器 给BeanFactory
@Import(TestImportSelector.class)
public @interface EnableMyImportSelected {
	String value();
}
