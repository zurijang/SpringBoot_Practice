package com.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;


public class MyConfigurationPropertiesImportSelector implements DeferredImportSelector {

	// import 할 클래스의 이름 리턴
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		MultiValueMap<String, Object> attr = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());
		
		// value 엘리먼트를 EnableMyConfigurationProperties 어노테이션을 통해 설정
		// 위 Annotation에 attribute는 1개만 지정할 수 있도록 getFirst 사용
		Class propertyClass = (Class) attr.getFirst("value");
		
		return new String[] { propertyClass.getName() };

	}

	
	
}
