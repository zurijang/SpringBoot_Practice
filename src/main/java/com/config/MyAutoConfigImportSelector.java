package com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// import 할 클래스 이름 정의 (config 클래스 파일 Bean 등록)
public class MyAutoConfigImportSelector implements DeferredImportSelector {

	private final ClassLoader classLoader;
	
	public MyAutoConfigImportSelector(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		List<String> autoConfigs = new ArrayList<>();
		
		// ImportCandidates 는 Iterable<String> 타입
		// load 메서드는 Class-path/META-INF/{파라미터로 전달된 Annotation의 Full Qualified Name).imports 파일로부터 조회
		Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);

//		for(String candidate : candidates) {
//		
//			autoConfigs.add(candidate);
//		
//		}
		
		candidates.forEach(candidate -> autoConfigs.add(candidate));
		
		// Method Reference
//		candidates.forEach(autoConfigs::add);
		
		// ToArray는 뒤에 넉넉한 사이즈의 Array를 주면 안에다가 컬렉션 값들을 복사하고
		// 만약에 컬렉션의 사이즈보다 더 작은 크기의 Array를 리턴하면 걔를 무시하고 새로운 Array를 만들어서 값을 복사하고 리턴해줌
		// 이 경우 사이즈를 모르니까 사이즈 없는 빈 Array를 활용해 타입정보만 넣어줌
		return autoConfigs.toArray(new String[0]);
		
//		return autoConfigs.stream().toArray(String[]::new);

//		return Arrays.copyOf(autoConfigs.toArray(), autoConfigs.size(), String[].class);

		
	}
	
}
