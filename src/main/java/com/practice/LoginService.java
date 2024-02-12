package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.vo.Member;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	public Member selectMemberInfo(Member member) {
		
		Member memberInfo = loginRepository.selectMemberInfo(member);
		
		if( encoder.matches(member.getPassword(), memberInfo.getPassword() ) ) {
			return memberInfo;
		} else {
			return null;
		}
		
	}
	
	public int insertMember(Member member) {
		
		Member newMember = new Member();
		newMember.setEmail( member.getEmail() );
		newMember.setPassword( encoder.encode( member.getPassword() ) );
		
		return loginRepository.insertMember(newMember);
	}
	
}
