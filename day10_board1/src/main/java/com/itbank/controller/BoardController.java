package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.model.PagingDTO;
import com.itbank.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/board")
	public String board() {
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list")
	public ModelAndView list(String nowPage, String keyword) {
//		ModelAndView mav = new ModelAndView();
//		int total = boardService.cntBoard();
//		if(nowPage == null) {
//			nowPage = "1";
//		}
//		PagingDTO paging = new PagingDTO(total, Integer.parseInt(nowPage));
//		List<BoardDTO> list = boardService.getList(paging);
//		mav.addObject("paging", paging);
//		mav.addObject("list", list);				
		ModelAndView mav = new ModelAndView("/board/list");
		if(keyword != null && keyword.contains(",")) {
			keyword = keyword.substring(keyword.lastIndexOf(",") + 1);
		}
		int total = boardService.cntBoardByTitle(keyword);
		if(nowPage == null) {
			nowPage = "1";
		}
		PagingDTO paging = new PagingDTO(total, Integer.parseInt(nowPage));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("paging", paging);
		map.put("keyword", keyword);
		List<BoardDTO> list = boardService.getListByTitle(map);
		mav.addObject("keyword", keyword);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/board/list")
	public ModelAndView search(String nowPage, String keyword) {	
		ModelAndView mav = new ModelAndView("redirect:/board/list");
		int total = boardService.cntBoardByTitle(keyword);
		if(nowPage == null) {
			nowPage = "1";
		}
		PagingDTO paging = new PagingDTO(total, Integer.parseInt(nowPage));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("paging", paging);
		map.put("keyword", keyword);
		List<BoardDTO> list = boardService.getListByTitle(map);
		mav.addObject("keyword", keyword);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/board/list/")
	
	@GetMapping("/board/write")
	public void write() {}
	
	@PostMapping("/board/write")
	public String write(BoardDTO board) {
		int row = boardService.write(board);
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/detail/{idx}")
	public ModelAndView detail(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/detail");
		BoardDTO dto = boardService.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/board/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/modify");
		BoardDTO dto = boardService.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/board/modify/{idx}")
	public String modify(BoardDTO board) {
		int row = boardService.modify(board);
		System.out.println(row != 0 ? "수정 성공" : "수정 실패");
		return "redirect:/board/mypage/" + board.getIdx() ;
	}
	
	@GetMapping("board/remove/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = boardService.remove(idx);
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		return "redirect:/board/list";
	}

}
