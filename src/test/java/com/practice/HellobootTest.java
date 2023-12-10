package com.practice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//SpringContainer를 띄우고 빈 구성 정보를 넣고 해당 빈을 가져와서 테스트 진행
@ExtendWith(SpringExtension.class)
//모든 빈 구성정보를 불러오는 클래스를 통해 Import와 ComponentScan 을 이용해서 자동 구성 빈, 애플리케이션 빈 이런 것들을 불러옴
@ContextConfiguration(classes = PracticeApplication.class)
//properties 파일을 읽어 test 진행 하도록 명시
@TestPropertySource("classpath:/application.properties")
public @interface HellobootTest {

}
