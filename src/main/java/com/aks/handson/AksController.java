package com.aks.handson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AksController {
	
	@GetMapping("/aks")
	public ResponseEntity<String> getResponse(){
		return ResponseEntity.ok("Its Amazing to learn AKS!!");	
	}

}
