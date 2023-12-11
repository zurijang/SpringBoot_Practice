package com.practice;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@HellobootTest
@Transactional
public class HelloServiceCountTest {

	// 테스트 대상을 주입 받아서 사용학시 위한 목적
	@Autowired HelloService helloService;
	// 테스트해서 검증을 하기 위한 목적
	@Autowired HelloRepository helloRepository;
	
	@Test
	void sayHelloIncreaseCount() {
		
		IntStream.rangeClosed(1, 10).forEach(count -> {
		
			helloService.sayHello("Zuri");
			Assertions.assertThat(helloRepository.countOf("Zuri")).isEqualTo(count);
		
		});
	}
	
}
