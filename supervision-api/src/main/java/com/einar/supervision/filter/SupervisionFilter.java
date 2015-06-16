package com.einar.supervision.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.einar.supervision.service.HitService;

public class SupervisionFilter implements Filter {

	private static HitService hitService;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
		
		long start = System.currentTimeMillis();
		
		filterChain.doFilter(request, response) ;
		
		long end = System.currentTimeMillis();

		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());
		
		hitService.addHit(start, (end-start), path, true);
		
//		System.out.println("Session ID : "+req.getSession(false).getId());
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		WebApplicationContext springContext = 
		        WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		hitService = springContext.getBean(HitService.class);
		
	}

}
