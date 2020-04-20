package com.app.myspringevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SperingSendEvent {
	@Autowired
	ApplicationContext context;

	public void sendEvent(){
		//发布一个事件 就是触发这个事件
		context.publishEvent(new SpringMailEvent(context));
	}
}
