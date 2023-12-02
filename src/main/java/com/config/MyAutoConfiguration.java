package com.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// MyAutoConfiguration 이라는 Annotation을 어떤 클래스에 붙이면 이거는 configuration 클래스로 선언한 것과 동일한 효과
@Configuration(proxyBeanMethods = false)
public @interface MyAutoConfiguration {
	
}
