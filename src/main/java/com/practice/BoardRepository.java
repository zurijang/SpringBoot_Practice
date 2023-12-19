package com.practice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardRepository {

	// 게시판 목록 조회
	List<Board> selectBoardList();
	
}
