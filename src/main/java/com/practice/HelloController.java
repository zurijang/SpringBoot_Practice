package com.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private final HelloService helloService;
	
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam("name") String name) {
		
		// null 혹은 공백만 들어올 경우 예외처리
		if(name == null || name.trim().length() == 0) throw new IllegalArgumentException();
		
		// 파라미터 name 겁증 후 비즈니스 로직에 전달
		return helloService.sayHello(name);
		
	}
	
}
