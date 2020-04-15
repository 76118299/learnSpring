package com.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.app.testimportselectoer.EnableMyImportSelected;
import com.app.testimportselectoer.TestImportSelector;
import com.myimportdefinitionregistrar.TestImportBeanDefinitionRegistrar;
import com.testimportware.EnableMyUtli;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@ComponentScan("com.dao")
@EnableMyImportSelected("test")  //引入ImportSelecter
@Import(TestImportBeanDefinitionRegistrar.class)
@EnableMyUtli(userName = "aa")
@EnableAspectJAutoProxy
@EnableWebMvc //消息转换才生效
public class Appconfig implements WebMvcConfigurer {
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		converters.add( new FastJsonHttpMessageConverter()); //添加请求转换器
	}
}
