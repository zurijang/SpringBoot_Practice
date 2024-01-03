package com.practice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView board() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Board> list = boardService.selectBoardList();
		
		System.out.println(list);
		
		mav.addObject("list", list);
		
		mav.setViewName("board_list");
		
		return mav;
		
	}
	
	@GetMapping("/detail")
	public ModelAndView readBoard(@RequestParam("bid") String bid) {
		
		ModelAndView mav = new ModelAndView();
		
		Board board = boardService.readBoard(bid);
		
		mav.addObject("board", board);
		
		mav.setViewName("board_detail");
		
		return mav;
		
	}
	
	@GetMapping("/regist")
	public ModelAndView registGet() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board_regist");
		
		logger.info("this is board regist get");

		return mav;
		
	}
	
	@PostMapping("/regist")
	public ModelAndView registPost(Board board) {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println(board.getTitle() + " " + board.getContent());
		
		int result = boardService.insertBoard(board);
		
		mav.setViewName("redirect:/board/list");
		
		logger.info("this is board regist post");
		
		return mav;
		
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBoard(@RequestParam("bid") String bid) {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println(bid);
		
		int result = boardService.deleteBoard(bid);
		
		mav.setViewName("redirect:/board/list");
		
		return mav;
	}
	
}
