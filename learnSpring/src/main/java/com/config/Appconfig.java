package com.config;

import com.app.testimportselectoer.EnableMyImportSelected;
import com.app.testimportselectoer.TestImportSelector;
import com.myimportdefinitionregistrar.TestImportBeanDefinitionRegistrar;
import com.testimportware.EnableMyUtli;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.dao")
@EnableMyImportSelected("test")  //引入ImportSelecter
@Import(TestImportBeanDefinitionRegistrar.class)
@EnableMyUtli(userName = "aa")
@EnableAspectJAutoProxy
public class Appconfig {
}
