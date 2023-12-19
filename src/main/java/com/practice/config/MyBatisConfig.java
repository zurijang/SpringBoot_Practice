package com.practice.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value="com.practice", sqlSessionFactoryRef="SqlSessionFactory")
public class MyBatisConfig {

	@Value("${spring.datasource.mapperLocation}")
	String mPath;
	
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource DataSource() {
		
		return DataSourceBuilder.create().build();
		
	}
	
	@Bean(name="SqlSessionFactory")
	public SqlSessionFactory SqlSessionFactory(@Qualifier("dataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mPath));
		
		return sqlSessionFactoryBean.getObject();
		
	}
	
	@Bean(name="SessionTemplate")
	public SqlSessionTemplate SqlSessionTEmplate(@Qualifier("SqlSessionFactory") SqlSessionFactory firstSqlSessionFactory) {
		return new SqlSessionTemplate(firstSqlSessionFactory);
	}
	
	
}
