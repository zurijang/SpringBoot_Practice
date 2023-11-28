package com.practice;

public class SimpleHelloService implements HelloService {

	// name 파라미터를 활용해서 문자열을 반환하는 서비스 로직
	@Override
	public String sayHello(String name) {
		
		return "Hello " + name;
		
	}
	
}
