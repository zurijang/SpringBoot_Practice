package com.practice.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("simpleHelloService")
public class SimpleHelloService implements HelloService {

	private final HelloRepository helloRepository;
	
	public SimpleHelloService(@Qualifier("helloRepositoryJdbc")HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}
	
	// name 파라미터를 활용해서 문자열을 반환하는 서비스 로직
	@Override
	public String sayHello(String name) {
		
		this.helloRepository.increaseCount(name);
		
		return "Hello " + name;
		
	}

	@Override
	public int countOf(String name) {
		
		return this.helloRepository.countOf(name);

	}
	
	
	
}
