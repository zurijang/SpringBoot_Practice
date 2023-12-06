package com.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import com.config.ConditionalMyOnClass;
import com.config.MyAutoConfiguration;

// MyAutoConfiguration 이라는 기능에 의해서 사용되는 대상이라는 것을 명시
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

	
	
	// 기본적으로 Bean은 Method 명을 따라가지만 충돌이 날 경우 지정가능
	@Bean("tomcatWebServerFactory")
	// Bean으로 등록된 Method의 반환타입과 동일한 Bean 정보가 없으면 등록 (Spring Boot Annotation)
	@ConditionalOnMissingBean  
	public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
		
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		
		factory.setContextPath(properties.getContextPath());
		factory.setPort(properties.getPort()); 
		
		return factory;
		
	}
	
}
