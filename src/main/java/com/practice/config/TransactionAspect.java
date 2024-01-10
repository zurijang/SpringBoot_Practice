package com.practice.config;

import java.util.Collections;
import java.util.List;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import lombok.RequiredArgsConstructor;

/**
 * Transaction 설정
 * Service 로직에서 에러 발생시 transaction rollback 처리
 */

@Configuration
@RequiredArgsConstructor
public class TransactionAspect {

	private PlatformTransactionManager transactionManager;
	
	private final String EXECUTION = "execution(* *..*Service*.*(..))";
	
	@Bean
	public TransactionInterceptor transactionAdvice() {
		
		List<RollbackRuleAttribute> rollbackRules = Collections.singletonList(new RollbackRuleAttribute(Exception.class));
		
		RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
		transactionAttribute.setRollbackRules(rollbackRules);
		transactionAttribute.setName("*");
		
		MatchAlwaysTransactionAttributeSource attributeSource = new MatchAlwaysTransactionAttributeSource();
		attributeSource.setTransactionAttribute(transactionAttribute);
		
		TransactionInterceptor interceptor = new TransactionInterceptor();
		interceptor.setTransactionManager(transactionManager);
		interceptor.setTransactionAttributeSource(attributeSource);
		
		return interceptor;
		
	}
	
	@Bean
	public Advisor transactionAdvisor() {
		
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(EXECUTION);
		
		return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
		
	}
	
}
