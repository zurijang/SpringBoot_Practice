package com.practice.handler;

import java.util.ArrayList;
import java.util.List;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggerInterceptor implements HandlerInterceptor {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("===================================");
		logger.info("========== Handler BEGIN ==========");
		logger.info("Request URI ==> " + request.getRequestURI());
		
		String requestURI = request.getRequestURI();
		List<String> passwordRequestURI = new ArrayList<>();
		passwordRequestURI.add("/login");
		passwordRequestURI.add("/signup");
		
		// TODO interceptor 로 암호화해서 처리하면될거라 생각했는데 파라미터를 객체로 저장됨...
		// TODO 등록된 Bean 활용해서 암호화
		if( request.getMethod().toLowerCase().equals("post") &&  passwordRequestURI.contains(requestURI) ) {
			System.out.println("패스워드 입력됐다!");
			String inputPassword = request.getParameter("password");
			if( inputPassword != null && !inputPassword.equals("") ) {
				StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
				jasypt.setPassword("1q2w3e4r!");
				
				request.setAttribute( "password", jasypt.encrypt(inputPassword) );
			}
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("=========== Handler END ===========");
		logger.info("===================================");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	
	
}
