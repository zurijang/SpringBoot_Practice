package com.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.config.MyAutoConfiguration;

@MyAutoConfiguration
public class PropertyPlaceholderConfig {

	@Bean
	PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
