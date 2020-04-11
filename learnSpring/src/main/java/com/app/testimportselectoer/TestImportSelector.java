package com.app.testimportselectoer;

import com.dao.AppDao;
import com.dao.AppDao1;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * 回把返回的类名 创建BD 加入BeanFacotry
 * 实现 ImportSelector接口
 */
public class TestImportSelector implements ImportSelector {
	/**
	 *
	 * @param importingClassMetadata  能够获取@EnableMyImportSelected注解 的值 进行条件判断
	 * @return
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// 获取 @EnableMyImportSelected注解中value的值
		Set<String> enableMyImportSelected = importingClassMetadata.getMetaAnnotationTypes("EnableMyImportSelected");
		  //将appDao1 就是后置处理器BeanPostPorcessor的实现类添加到BeanFactory中 。在spring初始化的时候执行后置处理器
		  //用来生成代理对象
		return new String[]{AppDao1.class.getName()};  //就可以通过ApplicatonContext#getBean（） 获取到
	}
}
