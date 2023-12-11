package com.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServicetest {

	private static HelloRepository helloRepositoryStub = new HelloRepository() {

		@Override
		public Hello findHello(String name) {
			return null;
		}

		@Override
		public void increaseCount(String name) {

		}
		
	};
	
	// 서버 동작을 시키지 않고 Java 단에서 테스트 수행 (테스트 수행 속도 빠름)
	@Test
	void simpleHelloService() {
		
		// 빈 의존 오브젝트 주입
		SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);
		
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
