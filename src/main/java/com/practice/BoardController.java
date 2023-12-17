package com.practice;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String board() {
		
		logger.info("this is board list");
		
		return "/board_list.html";
		
	}
	
	@GetMapping("/regist")
	public String registGet() {
		
		logger.info("this is board regist get");

		return "/board_regist.html";
		
	}
	
	@PostMapping("/regist")
	public String registPost(Board board) {
		
		logger.info("this is board regist post");
		
		int result = boardService.insertBoard(board);
		
		return "redirect:/board/regist";
		
	}
	
}