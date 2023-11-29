package com.practice;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Class Level에 /hello 요청 지정
@RestController
public class HelloController {
	
	private final HelloService helloService;
	
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}
	
	// Class Level 의 /hello 요청 중 Get Method 만 처리 (따로 요청을 지정하지 않았을 경우)
	@GetMapping("/hello")
	public String hello(@RequestParam("name") String name) {
		
		// 파라미터 name 겁증 후 비즈니스 로직에 전달
		// Objects.requireNonNull Object를 넘겨두고 만약에 Null이라면 예외를 던지고 아니면 이 값을 그대로 리턴해줌 (Null Check)
		return helloService.sayHello(Objects.requireNonNull(name));
		
	}
}
