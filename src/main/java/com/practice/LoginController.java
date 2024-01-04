package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.practice.vo.Member;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public ModelAndView loingPage() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		
		return mav;
		
	}
	
	@PostMapping("/login")
	public ModelAndView processLogin(Member member) {
		
		ModelAndView mav = new ModelAndView();
		
		loginService.selectMemberInfo(member);
		
		mav.setViewName("redirect:/board/list");
		
		return mav;
		
	}
	
	@GetMapping("/signup")
	public ModelAndView signupPage() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("signup");
		
		return mav;
		
	}
	
	@PostMapping("/signup")
	public ModelAndView processSignup(Member member) {
		
		ModelAndView mav = new ModelAndView();
		
		int result = loginService.insertMember(member);
		
		mav.setViewName("redirect:/login");
		
		return mav;
		
	}
	
}
