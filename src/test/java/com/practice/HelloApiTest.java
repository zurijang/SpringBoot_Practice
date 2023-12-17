package com.practice;

// Assertions.assertThat 이 반복적으로 사용되어 static import 선언
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


public class HelloApiTest {

	@Test
	void helloAPI() {

		// http localhost:8080/hello?name=Spring
		TestRestTemplate rest = new TestRestTemplate();
		
		// Placeholder 치환자를 넣어놓고 따로 파라미터로 전달하는 방식 사용
		ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");
		
		// Status Code : 200
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		// header(Content-type : text/plain
		assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
		// Body : Hello Spring
		assertThat(res.getBody()).isEqualTo("*Hello Spring*");
		
	}
	
	// name 파라미터가 전달되지 않은 경우 500 에러 (INTERVAL_SERVER_ERROR) 발생했는지 확인
	@Test
	void failHelloAPI() {

		// http localhost:8080/hello?name=Spring
		TestRestTemplate rest = new TestRestTemplate();
		
		// Placeholder 치환자를 넣어놓고 따로 파라미터로 전달하는 방식 사용
		ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name=", String.class);
		
		// Status Code : 500
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
