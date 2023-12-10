package com.config.autoconfig;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.config.ConditionalMyOnClass;
import com.config.EnableMyConfigurationProperties;
import com.config.MyAutoConfiguration;
import com.zaxxer.hikari.HikariDataSource;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
// 자동구성 클래스가 컨디셔널 조건이 충족되어서 사용 될 때 그 때만 이 property 파일이 빈으로 등록
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
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
	
}
