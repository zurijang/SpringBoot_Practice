package com.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@HellobootTest
@Transactional
public class HelloRepositoryTest {

	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired HelloRepository helloRepository;
	
	@Test
	void findHelloFailed() {
		Assertions.assertThat(helloRepository.findHello("Zuri")).isNull();
	}
	
	@Test
	void increaseCount() {
		Assertions.assertThat(helloRepository.countOf("Zuri")).isEqualTo(0);
		
		helloRepository.increaseCount("Zuri");
		Assertions.assertThat(helloRepository.countOf("Zuri")).isEqualTo(1);
		
		helloRepository.increaseCount("Zuri");
		Assertions.assertThat(helloRepository.countOf("Zuri")).isEqualTo(2);
	}
	
}
