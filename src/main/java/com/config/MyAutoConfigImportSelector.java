package com.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// import 할 클래스 이름 정의 (config 클래스 파일 Bean 등록)
public class MyAutoConfigImportSelector implements DeferredImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		return new String[] {
				"com.config.autoconfig.DispatcherServletConfig",
				"com.config.autoconfig.TomcatWebServerConfig",
		};
		
	}
	
}
