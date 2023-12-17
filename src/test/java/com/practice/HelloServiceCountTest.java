package com.practice;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.practice.hello.HelloRepository;
import com.practice.hello.HelloService;

//설정한 빈들을 컨테이너로 로딩하는데 웹 환경을 세팅하지 않도록 설정
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
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
