package com.practice;

import java.io.IOException;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

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
				
				servletContext.addServlet("hello", new HttpServlet() {

					@Override
					protected void service(HttpServletRequest req, HttpServletResponse resp)
							throws ServletException, IOException {

						// 응답코드 설정
						resp.setStatus(200);
						// 헤더 설정
						resp.setHeader("Content-Type", "text/plain");
						// 바디 설정
						resp.getWriter().println("Hello Servlet");
						
					}
					
				}).addMapping("/hello");
				
			}
			
		});

		webServer.start();
		
	}

}
