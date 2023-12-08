package com.config.autoconfig;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import com.config.MyAutoConfiguration;
import com.config.MyConfigurationProperties;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

	@Bean
	BeanPostProcessor propertyPostProcessor(Environment env) {
		return new BeanPostProcessor() {

			// BeanPostProcessor의 빈 오브젝트 생성 후 가공
			// 모든 빈 오브젝트를 만들 때마다 한 번씩 실행
			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

				// 사용자 애노테이션 MyConfigurationProperties 가 달린 클래스만 진행
				// bean 클래스에 MyConfigurationProperties 어노테이션이 있으면 해당 annotation return
				MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);
				
				if (annotation == null) return bean;
				
				// prefix 정보 불러오기
				Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(annotation);
				String prefix = (String) attrs.get("prefix");
				
				// MyConfigurationProperties Annotation이 붙어있는 경우에는 Property 값을 바인딩
				return Binder.get(env).bindOrCreate(prefix, bean.getClass());
			}
			
		};
	}
	
}
