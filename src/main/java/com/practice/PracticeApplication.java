package com.practice;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class PracticeApplication {

	public static void main(String[] args) {
		
		// Spring Container 생성
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() {

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

		// Spring Container 에 HelloController 라는 클래스를 활용하여 Bean 을 등록
		// 파라미터를 주입받는 생성자가 있다면 해당 클래스도 Bean으로 등록해줘야 함
		applicationContext.registerBean(HelloController.class);
		// Interface 형태의 Service를 등록하는 것이 아닌, 구현체 SimpleHelloService 를 Bean으로 등록
		// 런타임 시 구현체 SimpleHelloService 를 스캔하면서 interface class 를 상속받고있다면, Spring Container가 연관되는 클래스의 생성자 파라미터에 주입을 해줌
		applicationContext.registerBean(SimpleHelloService.class);
		// 등록한 Bean 정보로 Spring Container 초기화
		applicationContext.refresh();
		
		
		
	}

}
