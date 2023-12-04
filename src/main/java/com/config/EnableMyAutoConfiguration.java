package com.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyAutoConfigImportSelector.class) // @ComponentScan 기준 베이스 패키지와 다른 패키지에 @Configuration 이 붙은 Class을 Scan 대상으로 지정
public @interface EnableMyAutoConfiguration {

}