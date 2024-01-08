package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.practice.vo.Member;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public ModelAndView loingPage(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("sessionInfo") != null) {
			
			mav.setViewName("redirect:/board/list");
			
		} else {
		
		mav.setViewName("login");
		
		}
		
		return mav;
		
	}
	
	@PostMapping("/login")
	public ModelAndView processLogin(HttpSession session, Member member) {
		
		ModelAndView mav = new ModelAndView();
		
		Member selectedMember = loginService.selectMemberInfo(member);
		
		if(selectedMember == null) {
		
			mav.setViewName("redirect:/login");
		
		} else {
		
		session.setAttribute("sessionInfo", selectedMember);
		mav.setViewName("redirect:/board/list");
		
		}
		
		return mav;
		
	}
	
	@GetMapping("/signup")
	public ModelAndView signupPage(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("sessionInfo") != null) {
			
			mav.setViewName("redirect:/board/list");
			
		} else {
		
		mav.setViewName("signup");
		
		}
		
		return mav;
		
	}
	
	@PostMapping("/signup")
	public ModelAndView processSignup(HttpSession session, Member member) {
		
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("sessionInfo") != null) {
		
			mav.setViewName("redirect:/board/list");
			
		} else {
		
			int result = loginService.insertMember(member);
			mav.setViewName("redirect:/login");
			
		}
		
		return mav;
		
	}
	
}
