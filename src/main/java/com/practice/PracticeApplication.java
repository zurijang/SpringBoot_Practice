package com.practice;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.config.MySpringBootApplication;

@MySpringBootApplication
public class PracticeApplication {
	
	// 초기화 작업 혹은 컨테이너의 기능 수행 확인방법
	// 다른 빈을 주입받는 방법, Environment : 스프링 안에 들어있는 환경정보를 추상화
	@Bean
	ApplicationRunner applicationRunner(Environment env) {
		
		// ApplicationRunner 인터페이스의 메소드는 run() 하나뿐임으로 lambda 식으로 표현 가능
		return args -> {
			
			String name = env.getProperty("my.name");
			System.out.println("my.name = " + name);
			
		};
		
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(PracticeApplication.class, args);
		
	}
	
}
