package com.practice.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfig {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Pointcut("execution(* *..*Service*.*(..))")
	private void serviceExecution() {}
	
	@Before(value = "serviceExecution()")
	public void beforeService(JoinPoint joinPoint) throws Throwable {
		
		logger.info("BeforeService logging START");
		System.out.println(joinPoint);
		logger.info("BeforeService logging END");
		
	}
	
}
