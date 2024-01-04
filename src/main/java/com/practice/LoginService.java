package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.vo.Member;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	public Member selectMemberInfo(Member member) {
		
		Member memberInfo = loginRepository.selectMemberInfo(member);
		
		return memberInfo;
		
	}
	
	public int insertMember(Member member) {
		return loginRepository.insertMember(member);
	}
	
}
