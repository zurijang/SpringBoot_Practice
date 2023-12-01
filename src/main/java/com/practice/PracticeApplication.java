package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@MySpringBootAnnotation
public class PracticeApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(PracticeApplication.class, args);
		
	}
	
}
