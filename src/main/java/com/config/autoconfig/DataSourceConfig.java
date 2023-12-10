package com.config.autoconfig;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.config.ConditionalMyOnClass;
import com.config.EnableMyConfigurationProperties;
import com.config.MyAutoConfiguration;
import com.zaxxer.hikari.HikariDataSource;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
// 자동구성 클래스가 컨디셔널 조건이 충족되어서 사용 될 때 그 때만 이 property 파일이 빈으로 등록
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
// AOP 기능을 넣기위한 Annotation, @Transactional 을 사용할 수 있게함
@EnableTransactionManagement
public class DataSourceConfig {

	@Bean
	// HikariDataSource가 있으면 빈 생성
	@ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
	@ConditionalOnMissingBean
	DataSource hikariDataSource(MyDataSourceProperties properties) {
		
		HikariDataSource dataSource = new HikariDataSource();
		
		dataSource.setDriverClassName(properties.getDriverClassName());
		dataSource.setJdbcUrl(properties.getUrl());
		dataSource.setUsername(properties.getUsername());
		dataSource.setPassword(properties.getPassword());
		
		return dataSource;
		
	}
	
	@Bean
	// 앞에 메서드에서 DataSourceBean 이 만들어지지 않았을 경우 빈 생성
	@ConditionalOnMissingBean
	DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass( (Class<? extends Driver> ) Class.forName(properties.getDriverClassName()));
		dataSource.setUrl(properties.getUrl());
		dataSource.setUsername(properties.getUsername());
		dataSource.setPassword(properties.getPassword());
		
		return dataSource;
	}
	
	@Bean
	// 빈 메소드가 실행될 때 이미 스프링 컨테이너의 빈 구성 정보에 DAtaSource 타입의 빈이 딱 한 개만 등록이 되었을 때 DataSource를 가져와 사용함
	@ConditionalOnSingleCandidate(DataSource.class)
	@ConditionalOnMissingBean
	JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	// 빈 메소드가 실행될 때 이미 스프링 컨테이너의 빈 구성 정보에 DAtaSource 타입의 빈이 딱 한 개만 등록이 되었을 때 DataSource를 가져와 사용함
	@ConditionalOnSingleCandidate(DataSource.class)
	@ConditionalOnMissingBean
	JdbcTransactionManager jdbcTransactionManager(DataSource dataSource) {
		return new JdbcTransactionManager(dataSource);
	}
	
}
