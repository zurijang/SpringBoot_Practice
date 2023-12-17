package com.practice.hello;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// 빈 스캔 대상
@Repository
public class HelloRepositoryJdbc implements HelloRepository {

	private final JdbcTemplate jdbcTemplate;
	
	public HelloRepositoryJdbc (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Hello findHello(String name) {
		// 쿼리 조회결과가 NULL 일 경우 예외를 던짐으로 처리 필요
		try {
			return jdbcTemplate.queryForObject("select * from member where name = '" + name + "'", 
					new RowMapper<Hello>() {
	
						@Override
						public Hello mapRow(ResultSet rs, int rowNum) throws SQLException {
	
							Hello hello = new Hello(rs.getString("name"), rs.getInt("count")); 
							
							return hello;
						
						}
				
			});
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void increaseCount(String name) {
		Hello hello = findHello(name);
		if (hello == null) {
			jdbcTemplate.update("insert into member values(?, ?)", name, 1);
		}
		else {
			jdbcTemplate.update("update member set count = ? where name =?", hello.getCount() + 1, name);
		}
	}

	
	
}
