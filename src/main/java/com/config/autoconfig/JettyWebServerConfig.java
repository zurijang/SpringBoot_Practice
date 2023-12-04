package com.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import com.config.ConditionalMyOnClass;
import com.config.MyAutoConfiguration;

// MyAutoConfiguration 이라는 기능에 의해서 사용되는 대상이라는 것을 명시
@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {

	// 기본적으로 Bean은 Method 명을 따라가지만 충돌이 날 경우 지정가능
	@Bean("jettyWebServerFactory")
	public ServletWebServerFactory servletWebServerFactory() {
		return new JettyServletWebServerFactory();
	}
	
}
