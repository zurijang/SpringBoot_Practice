package com.practice.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {

	// Configuration 의 디폴트 구성 특징 확인
	@Test
	void configuration() {
		
		// 1. 주소값까지 똑같은 Object 인지 확인했을 때 다른 Object 로 인식
//		Assertions.assertThat(new Common()).isSameAs(new Common());
		
		// 2. Common Object를 생성자로 초기화 후 비교, 동일한 Object 로 인식
//		Common common = new Common();
//		Assertions.assertThat(common).isSameAs(common);

		// 3. Common 이란 Bean을 통해서 주입받은 Bean1과 Bean2의 common 비교, 다른 Object 로 인식 (주소값이 다름)
//		MyConfig myConfig = new MyConfig();
//		Bean1 bean1 = myConfig.bean1();
//		Bean2 bean2 = myConfig.bean2();
//		Assertions.assertThat(bean1.common).isSameAs(bean2.common);
		
		// 4. MyConfig 클래스를 SpringContainer의 구성 정보로 사용을 하게 되면 동작하는 방식이 달라짐, 동일한 Object 로 인식
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(MyConfig.class);
		ac.refresh();
		
		Bean1 bean1 = ac.getBean(Bean1.class);
		Bean2 bean2 = ac.getBean(Bean2.class);
		
		Assertions.assertThat(bean1.common).isSameAs(bean2.common);
		
	}
	
	// 확장한 Proxy Object 를 통해서 Common Method 가 생성하는 Object의 개수를 하나로 제한하고 재사용하는지 테스트
	@Test
	void proxyCommonMethod() {
		MyConfigProxy myConfigProxy = new MyConfigProxy();
		
		Bean1 bean1 = myConfigProxy.bean1();
		Bean2 bean2 = myConfigProxy.bean2();
		
		Assertions.assertThat(bean1.common).isSameAs(bean2.common);
		
	}
	
	// Proxy Method 가 만들어지는 방식 (true 는 Default Value)
	// @Configuration(proxyBeanMethods = true)
	static class MyConfigProxy extends MyConfig {

		private Common common;
		
		@Override
		Common common() {
			
			if( this.common == null ) this.common = super.common();
			
			// common 이 null이면 superclass를 호출해서 Common Object를 하나 받아옴
			// 그게 아니면 필드에 저장해 둔 Caching
			return this.common;
		}
		
	}
	
	@Configuration
	static class MyConfig {
		
		@Bean
		Common common() {
			return new Common();
		}
		
		@Bean
		Bean1 bean1() {
			return new Bean1(common());
		}
		
		@Bean
		Bean2 bean2() {
			return new Bean2(common());
		}
		
	}
	
	static class Bean1 {
		
		private final Common common;
		
		Bean1(Common common) {
			this.common = common;
		}
		
	}
	
	static class Bean2 {
		
		private final Common common;
		
		Bean2(Common common) {
			this.common = common;
		}
		
	}
	
	static class Common {
		
	}
	
	// Bean1 <-- Common
	// Bean2 <-- Common
	
}
