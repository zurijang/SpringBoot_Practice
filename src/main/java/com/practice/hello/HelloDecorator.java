package com.practice.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// @Primary HelloService 구현체 가 2개 일 때 Autowiring 에 우선되도록 지정
@Service
@Primary
public class HelloDecorator implements HelloService {

	private final HelloService helloService;
	
	// HelloDecorator 기준 자기자신에 @Primary가 붙어 HelloService 오브젝트 타입의 구현체는 1개
	public HelloDecorator(@Qualifier("simpleHelloService")HelloService helloService) { 
		this.helloService = helloService;
	}
	
	@Override
	public String sayHello(String name) {

		return "*" + helloService.sayHello(name) + "*";
	
	}

	@Override
	public int countOf(String name) {
		return helloService.countOf(name);
	}
	
	
	
}
