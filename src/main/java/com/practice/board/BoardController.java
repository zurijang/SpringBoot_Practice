package com.practice.board;

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

import com.practice.vo.Board;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView board(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("sessionInfo") == null) {
			
			mav.setViewName("redirect:/login");

		} else {
		
			List<Board> list = boardService.selectBoardList();
			
			mav.addObject("list", list);
			mav.setViewName("board/board_list");
		
		}
		
		return mav;
		
	}
	
	@GetMapping("/detail")
	public ModelAndView readBoard(HttpSession session, @RequestParam("bid") String bid) {
		
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("sessionInfo") == null) {
			
			mav.setViewName("redirect:/login");

		} else {
		
			Board board = boardService.readBoard(bid);
		
			mav.addObject("board", board);
			mav.setViewName("board/board_detail");
		
		}
		
		return mav;
		
	}
	
	@GetMapping("/regist")
	public ModelAndView registGet(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("sessionInfo") == null) {
			
			mav.setViewName("redirect:/login");

		} else {
		
			mav.setViewName("board/board_regist");
		
			logger.info("this is board regist get");

		}
		
		return mav;
		
	}
	
	@PostMapping("/regist")
	public ModelAndView registPost(HttpSession session, Board board) {
		
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("sessionInfo") == null) {
			
			mav.setViewName("redirect:/login");

		} else {
		
			int result = boardService.insertBoard(board);
			
			mav.setViewName("redirect:/board/list");
			
			logger.info("this is board regist post");
		
		}
			
		return mav;
		
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBoard(HttpSession session, @RequestParam("bid") String bid) {
		
		ModelAndView mav = new ModelAndView();

		if(session.getAttribute("sessionInfo") == null) {
			
			mav.setViewName("redirect:/login");

		} else {		
		
			int result = boardService.deleteBoard(bid);
		
			mav.setViewName("redirect:/board/list");
		
		}
		
		return mav;
	}
	
}
