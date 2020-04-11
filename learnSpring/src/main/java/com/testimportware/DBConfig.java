package com.testimportware;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * ImportAware 可以获取到EnableMyUtli 注解的值
 */
@Component
public class DBConfig implements ImportAware {
	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		Map<String, Object> annotationAttributes = importMetadata.getAnnotationAttributes(EnableMyUtli.class.getName());

	}
}
