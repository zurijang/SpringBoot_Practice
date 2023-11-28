package com.practice;

import java.io.IOException;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PracticeApplication {

	public static void main(String[] args) {
		
		// Spring Container 생성  
		GenericApplicationContext applicationContext = new GenericApplicationContext();
	 	
		// Spring Container 에 HelloController 라는 클래스를 활용하여 Bean 을 등록
		applicationContext.registerBean(HelloController.class);
		// 등록한 Bean 정보로 Spring Container 초기화
		applicationContext.refresh();
		
		// 내부 Tomcat 실행
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer( new ServletContextInitializer() {

			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				
				servletContext.addServlet("FrontController", new HttpServlet() {

					@Override
					protected void service(HttpServletRequest req, HttpServletResponse resp)
							throws ServletException, IOException {
						
						// 인증, 보안, 다국어, 공통 기능 (서비스 로직 전처리)
						/* ... */
						
						// GET Method로 들어오는 /hello 요청에 대해서만 처리
						if( req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name()) ) {
						
							String name = req.getParameter("name");
							
							// Spring Container에 등록한 HelloController 클래스로 지정된 Bean 을 참조하여 Object 를 가져옴
							HelloController helloController = applicationContext.getBean(HelloController.class);
							// Request에서 Parameter name을 꺼내오는 것은 요청을 받은 클래스에서 처리하도록 함
							String ret = helloController.hello(name);

							// 헤더의 Content-type 설정
							resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
							// 바디 설정
							resp.getWriter().println(ret);
						
						} 
						else {
							
							// 의도하지 않은 요청으로 들어왔을 때 응답으로 BAD_REQUEST 리턴
							resp.setStatus(HttpStatus.NOT_FOUND.value());
							
						}
						
					}
					
				}).addMapping("/*");
				
			}
			
		});

		webServer.start();
		
	}

}
