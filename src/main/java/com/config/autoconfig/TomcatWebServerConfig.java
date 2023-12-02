package com.config.autoconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.config.MyAutoConfiguration;

// MyAutoConfiguration 이라는 기능에 의해서 사용되는 대상이라는 것을 명시
@MyAutoConfiguration
public class TomcatWebServerConfig {

	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}
	
}
