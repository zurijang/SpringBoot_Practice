package com.practice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardRepository {

	// 게시판 목록 조회
	List<Board> selectBoardList();
	
	// 게시판 게시글 등록
	int insertBoard(Board board);

	// 게시판 게시글 삭제
	int deleteBoard(String bid);
}
