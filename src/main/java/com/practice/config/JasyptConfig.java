package com.practice.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.salt.RandomSaltGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
	
	private String algorithm = "PBEWithMD5AndDES";

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword("ajsjd2i2UQU+q9w=1298qjwjznv");
		config.setAlgorithm(algorithm);
//		config.setSaltGenerator(new RandomSaltGenerator());
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setStringOutputType("base64");
		
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		encryptor.setConfig(config);
		return encryptor;
	}
    
}
