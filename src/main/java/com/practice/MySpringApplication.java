package com.practice;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

	public static void run(Class<?> applicationClass, String... args) {
		// Spring Container 생성
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {

			@Override
			protected void onRefresh() {
				
				super.onRefresh();
				
				// Servlet Container 초기화
				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
				
				WebServer webServer = serverFactory.getWebServer( servletContext -> {
						// 전체 요청에 대해서 Spring Container의 Bean 정보를 DispatcherServlet에 전달하여 맵핑이 이루어질 수 있도록 처리 
						servletContext.addServlet( "dispatcherServlet", dispatcherServlet ).addMapping("/*");
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
