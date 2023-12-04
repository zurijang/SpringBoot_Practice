package com.practice.study;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ConditionalTest {

	@Test
	void conditional() {
		
		/* Way 1 */
		// Conditional :: true
		// 1. Bean 이 등록될 Application Context 생성
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(Config1.class);
		ac.refresh();
		
		MyBean bean = ac.getBean(MyBean.class);
		
		// Conditional :: false
		AnnotationConfigWebApplicationContext ac2 = new AnnotationConfigWebApplicationContext();
		ac2.register(Config2.class);
		ac2.refresh();
		
//		MyBean bean2 = ac2.getBean(MyBean.class);
		// Config2 클래스의 Conditional이 false 로 return 되어 Bean으로 등록되지 않음
		// 그로인해 Bean이 등록되지 않아 NoSuchBeanDefinitionException 이 발생하여 테스트 에러 발생 -> 예외를 잡도록 테스트 구성
		
		/* Way 2 */
		// Config1 Configuration 에 MyBean 이 등록되어 있는지 확인
		ApplicationContextRunner contextRunner = new ApplicationContextRunner();
		contextRunner.withUserConfiguration(Config1.class)
			.run(context -> {
				Assertions.assertThat(context).hasSingleBean(MyBean.class);
				Assertions.assertThat(context).hasSingleBean(Config1.class);
			});
		
		// 재사용 하지 않는 경우 Config2를 참고하여 MyBean이 등록안되어 있는지 테스트
		new ApplicationContextRunner().withUserConfiguration(Config2.class)
			.run(context -> {
				Assertions.assertThat(context).doesNotHaveBean(MyBean.class);
				Assertions.assertThat(context).doesNotHaveBean(Config2.class);
			});
		
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Conditional(BooleanCondition.class)
	@interface BooleanConditional {
		boolean value();
	}
	
	
	@Configuration
	@BooleanConditional(true)
	static class Config1 {

		@Bean
		MyBean myBean() {
			return new MyBean();
		}
		
	}
	
	@Configuration
	@BooleanConditional(false)
	static class Config2 {
		
		@Bean
		MyBean myBean() {
			return new MyBean();
		}
		
	}
	
	static class MyBean {
		
	}
	
	static class BooleanCondition implements Condition {

		// metadata을 통해 annotation singel element value 를 읽을 수 있음
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			
			Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional.class.getName());
			Boolean value = (Boolean)annotationAttributes.get("value");
			
			return value;
		}
		
	}
	
}
