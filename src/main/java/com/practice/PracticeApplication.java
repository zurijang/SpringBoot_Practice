package com.practice;

import java.io.IOException;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
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
							
							// 응답코드 설정
							resp.setStatus(HttpStatus.OK.value());
							// 헤더 설정
							resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
							// 바디 설정
							resp.getWriter().println("Hello Servlet " + name);
						
						}
						else if(req.getRequestURI().equals("/user")) {
							
							
							
						} else {
							
							// 의도하지 않은 요청으로 들어왔을 때 응답으로 BAD_REQUEST 리턴
							resp.setStatus(HttpStatus.BAD_REQUEST.value());
							
						}
						
					}
					
				}).addMapping("/*");
				
			}
			
		});

		webServer.start();
		
	}

}
