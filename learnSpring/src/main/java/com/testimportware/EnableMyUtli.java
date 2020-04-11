package com.testimportware;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(DBConfig.class)
@Configuration
public @interface EnableMyUtli {
	String userName ()  default  "root";
}
