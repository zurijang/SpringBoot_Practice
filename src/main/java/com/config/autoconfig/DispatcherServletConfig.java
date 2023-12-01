package com.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

// @Configuration 에 @Component 애노테이션이 포함되어있어 @ComponentScan에 읽혀질 수 있음
@Configuration
public class DispatcherServletConfig {

	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
	
}
