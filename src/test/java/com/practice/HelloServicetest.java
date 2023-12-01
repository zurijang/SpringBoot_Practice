package com.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServicetest {

	// 서버 동작을 시키지 않고 Java 단에서 테스트 수행 (테스트 수행 속도 빠름)
	@Test
	void simpleHelloService() {
		
		SimpleHelloService helloService = new SimpleHelloService();
		
		String ret = helloService.sayHello("Test");
		
		Assertions.assertThat(ret).isEqualTo("Hello Test");
		
	}
	
	@Test
	void helloDecorator() {
		
		HelloDecorator decorator = new HelloDecorator(name -> name);
		
		String ret = decorator.sayHello("Test");
	
		Assertions.assertThat(ret).isEqualTo("*Test*");
		
	}
}
