package com.aks.handson;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDUser;
import com.launchdarkly.sdk.server.LDClient;


@RestController
@RequestMapping("/api")
public class AksController {
	
	private static Logger logger = LoggerFactory.getLogger(AksController.class);
	
	@Autowired
	private LDClient ldClient;
	
	@GetMapping("/aks")
	public ResponseEntity<String> getResponse(){
		logger.info("Start getResponse : ");
		String response = null;
		boolean isTestLdEnabled = isTestFlagEnabled();
		if(isTestLdEnabled) {
			logger.info("Start processing when LD flag is turned ON ,{}",isTestLdEnabled);
			response = "Its Amazing to learn AKS with LD Flag ON";
		}else {
			logger.info("Start processing when LD flag is turned OFF ,{}",isTestLdEnabled);
			response = "Its Amazing to learn AKS with LD Flag OFF";
		}
		return ResponseEntity.ok(response);	
		
	}
	
	@GetMapping("/header")
	public ResponseEntity<String> getHeaders(@RequestHeader Map<String, String> headers) {
		HttpHeaders responseHeaders = new HttpHeaders();
		StringBuilder sb = new StringBuilder();

		headers.forEach((key, value) -> {
			// Add header to response
			responseHeaders.add(key, value);

			// Append to body string
			sb.append(key).append(": ").append(value).append("\n");
		});

		return ResponseEntity.ok().headers(responseHeaders).body(sb.toString());
	}
	
	public boolean isTestFlagEnabled() {

		LDContext context = LDContext.builder("aks-handson")
		        .kind("service")
		        .build();

        return ldClient.boolVariation("TEST-LD", context, false);
    }

}
