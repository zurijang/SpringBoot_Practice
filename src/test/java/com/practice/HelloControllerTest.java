package com.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

// name 파라미터 전달하는 경우의 단위테스트 진행
public class HelloControllerTest {

	// 1. 정상적인 상황 : name 파라미터를 전달하여 정상적으로 출력되는지 확인
	@Test
	void helloController() {
		
		// name 파라미터가 null 이 들어가면 진행시키지 않고 예외를 던지도록 구현된 것을 테스트
		// 생성자 파라미터 helloService 인터페이스 구현체가 한개여서 lambda로 전달 가능
		HelloController helloController = new HelloController(name -> name);
		
		String ret = helloController.hello("Test");
		
		Assertions.assertThat(ret).isEqualTo("Test");
		
	}
	
	// 2. 에러나는 상황 : name이 null로 들어오는 경우 테스트
	// null이 들어갔을 때 테스트를 한 경우 예외뜨는경우 테스트도 성공한 것으로 처리
	@Test
	void failHelloController() {
		
		HelloController helloController = new HelloController(name -> name);
		
		// null 파라미터는 전달하고 NullPointerException 이 발생했는지 테스트
		Assertions.assertThatThrownBy(() -> {
			helloController.hello(null);
		}).isInstanceOf(IllegalArgumentException.class);
		
		// 빈 문자열을 전달하고 예외가 발생하는지 테스트
		Assertions.assertThatThrownBy(() -> {
			helloController.hello("");
		}).isInstanceOf(IllegalArgumentException.class);
		
	}
	
}
