package com.practice;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class PracticeApplication {
	
	public static void main(String[] args) {
		
		// Spring Container 생성
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {

			@Override
			protected void onRefresh() {
				
				super.onRefresh();
				
				// Servlet Container 초기화
				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer( servletContext -> {
						// 전체 요청에 대해서 Spring Container의 Bean 정보를 DispatcherServlet에 전달하여 맵핑이 이루어질 수 있도록 처리 
						servletContext.addServlet( "dispatcherServlet", new DispatcherServlet(this) ).addMapping("/*");
				});
				
				// 내부 Tomcat 실행
				webServer.start();
				
			}
			
		};

		// Bean이 있는 Configuration Class 등록 (Configuration 등록)
		applicationContext.register(PracticeApplication.class);
		// 등록한 Bean 정보로 Spring Container 초기화
		applicationContext.refresh();
		
		
		
	}

}
