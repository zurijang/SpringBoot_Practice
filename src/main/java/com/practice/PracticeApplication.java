package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.config.MySpringBootApplication;

import jakarta.annotation.PostConstruct;

@MySpringBootApplication
public class PracticeApplication {
	
	private final JdbcTemplate jdbcTemplate;
	
	public PracticeApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// Spring Framework의 Lifecycle Interface를 이용한 방식을 간결하게 대체할 수 있는 용도로 사용
	// 모든 프로퍼티 세팅까지 다 끝나면 수행 구현
	@PostConstruct
	void init() {
		// Application 구동 시 인메모리 DB의 테이블 생성
		jdbcTemplate.execute("create table if not exists member(name varchar(50) primary key, count int)");
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(PracticeApplication.class, args);
		
	}
	
}
