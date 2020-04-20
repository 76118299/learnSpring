package com.app.myspringevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component //交给spring容器
public class SpringStartedListener implements ApplicationListener<ContextStartedEvent> {
	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		//获取事件源
		Object source = event.getSource();
		ApplicationContext applicationContext = event.getApplicationContext();
		System.out.println("ssssssssssssssssssssssss");

	}
}
