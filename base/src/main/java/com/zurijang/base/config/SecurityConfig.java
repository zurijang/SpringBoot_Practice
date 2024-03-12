package com.zurijang.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	/* Spring Security 비활성화 */
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web
							.ignoring()
								.requestMatchers("/static/**")
		;
	}
	
	/* HTTP 요청에 대한 Security 설정 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
					.authorizeHttpRequests(requests ->requests
						.requestMatchers("/login", "/signup").permitAll()
						.anyRequest().authenticated()
					)
					.formLogin(login ->login
						.loginPage("/login")
						.defaultSuccessUrl("/test")
					)
					.logout(logout ->logout
						.logoutSuccessUrl("/login")
						.invalidateHttpSession(true)
					)
					.csrf(csrf -> csrf.disable()
					)
				.build()
		;
	}
	
	/* Password Encoder */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
