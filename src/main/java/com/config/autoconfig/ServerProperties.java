package com.config.autoconfig;

import com.config.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "server")
public class ServerProperties {

	// application.properties 의 sever.contextPath
	private String contextPath;
	
	// application.properties 의 sever.port
	private int port;

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	} 
	
}
