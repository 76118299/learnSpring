package com.app.myspringevent;

import org.springframework.context.ApplicationEvent;

public class SpringMailEvent extends ApplicationEvent {
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private String content;
	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public SpringMailEvent(Object source) {
		super(source);
	}
}
