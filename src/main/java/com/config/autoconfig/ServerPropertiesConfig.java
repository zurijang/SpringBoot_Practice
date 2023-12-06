package com.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.config.MyAutoConfiguration;

@MyAutoConfiguration
public class ServerPropertiesConfig {

	@Bean
	public ServerProperties serverProperties(Environment environment) {
		
		// 1. Server 설정에 대한 객체
//		ServerProperties properties = new ServerProperties();
//		
//		properties.setContextPath(environment.getProperty("contextPath"));
//		properties.setPort(Integer.parseInt(environment.getProperty("port")));
		
		// 2. Spring Boot 제공 Binder 이용
		// 지정한 클래스의 property 이름이 일치하는 걸 찾아서 바인딩 해줌
		return Binder.get(environment).bind("", ServerProperties.class).get();
		
	}
	
}
