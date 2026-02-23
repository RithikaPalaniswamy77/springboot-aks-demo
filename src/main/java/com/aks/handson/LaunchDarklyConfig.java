package com.aks.handson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.launchdarkly.sdk.server.LDClient;

@Configuration
public class LaunchDarklyConfig {
	
	/*
	 * @Value("${launchdarkly.sdk.key}") private String ldKey;
	 * 
	 * @Bean public LDClient ldClient() { return new LDClient(ldKey); }
	 */

}
