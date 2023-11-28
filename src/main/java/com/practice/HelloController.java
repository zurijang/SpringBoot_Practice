package com.practice;

import java.util.Objects;

public class HelloController {

	public String hello(String name) {
		
		SimpleHelloService helloService = new SimpleHelloService();
		
		// 파라미터 name 겁증 후 비즈니스 로직에 전달
		// Objects.requireNonNull Object를 넘겨두고 만약에 Null이라면 예외를 던지고 아니면 이 값을 그대로 리턴해줌 (Null Check)
		return helloService.sayHello(Objects.requireNonNull(name));
		
	}
}
