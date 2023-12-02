package com.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.config.MyAutoConfiguration;

// MyAutoConfiguration 이라는 기능에 의해서 사용되는 대상이라는 것을 명시
@MyAutoConfiguration
public class DispatcherServletConfig {

	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
	
}
