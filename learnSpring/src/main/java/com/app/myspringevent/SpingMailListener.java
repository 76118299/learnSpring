package com.app.myspringevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component //交个spring管理
public class SpingMailListener implements ApplicationListener<SpringMailEvent> {
	@Override
	public void onApplicationEvent(SpringMailEvent event) {
		/**
		 * 输出邮件内容
		 */
		System.out.println(event.getContent());
	}
}
