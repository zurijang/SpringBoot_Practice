package com.practice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.practice.vo.Member;

@Mapper
@Repository
public interface LoginRepository {

	/* 회원조회 */
	Member selectMemberInfo(Member member);
	/* 회원가입 */
	int insertMember(Member member);
	
}
