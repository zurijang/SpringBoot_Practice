package com.practice.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.vo.Board;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	public List<Board> selectBoardList() {
		return boardRepository.selectBoardList();
	}
	
	public Board readBoard(String bid) {
		return boardRepository.readBoard(bid);
	}
	
	public int insertBoard(Board board) {
		return boardRepository.insertBoard(board);
	}
	
	public int deleteBoard(String bid) {
		return boardRepository.deleteBoard(bid);
	}
	
}
