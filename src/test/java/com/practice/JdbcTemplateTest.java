package com.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@HellobootTest
@Transactional
public class JdbcTemplateTest {
	
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	 @BeforeEach
	 void init() {
		 
		 jdbcTemplate.execute("create table if not exists member(name varchar(50) primary key, count int)");
		 
	 }
	 
	 @Test
	 // jdbc template, jdbc transaction manager, hikari data source 로 jdbc 자동 구성을 해주기때문에 connect 신경 X
	 void insertAndQuery() {
		 
		 jdbcTemplate.update("insert into member values(?, ?)", "Gildong Hong", 3);
		 jdbcTemplate.update("insert into member values(?, ?)", "SunSin Lee", 8);
		 
		 Long count = jdbcTemplate.queryForObject("select count(*) from member", Long.class);
		 Assertions.assertThat(count).isEqualTo(2);
		 
	 }
	
}
