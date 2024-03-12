package com.zurijang.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login() {
		
		return "/test";
	}
	
	@GetMapping("/signup")
	public String signupPage() {
		
		return "/signup";
	}
	
}
