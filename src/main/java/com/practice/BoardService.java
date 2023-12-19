package com.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	public List<Board> selectBoardList() {
		
		return boardRepository.selectBoardList();
		
	}
	
}
