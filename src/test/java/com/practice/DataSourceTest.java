package com.practice;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// SpringContainer를 띄우고 빈 구성 정보를 넣고 해당 빈을 가져와서 테스트 진행
@ExtendWith(SpringExtension.class)
// 모든 빈 구성정보를 불러오는 클래스를 통해 Import와 ComponentScan 을 이용해서 자동 구성 빈, 애플리케이션 빈 이런 것들을 불러옴
@ContextConfiguration(classes = PracticeApplication.class)
// properties 파일을 읽어 test 진행 하도록 명시
@TestPropertySource("classpath:/application.properties")
public class DataSourceTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	void connect() throws SQLException {
		
		Connection connection = dataSource.getConnection();
		connection.close();
	
	}
	
}
