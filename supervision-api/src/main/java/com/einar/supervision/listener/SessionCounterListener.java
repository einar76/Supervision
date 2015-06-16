package com.einar.supervision.listener;

import javax.servlet.http.HttpSessionEvent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.einar.supervision.service.SessionService;

@Component
public class SessionCounterListener implements javax.servlet.http.HttpSessionListener, ApplicationContextAware {

	@Autowired
	private SessionService sessionService;
	
	public void sessionCreated(HttpSessionEvent arg0) {
		sessionService.addSession(arg0.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		sessionService.closeSession(arg0.getSession().getId());
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (applicationContext instanceof WebApplicationContext) {
			((WebApplicationContext) applicationContext).getServletContext().addListener(this);
		} else {
			throw new RuntimeException("Must be inside a web application context");
		}
	}

}
