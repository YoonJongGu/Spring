package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.model.PagingDTO;
import com.itbank.model.ReplyDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView list(int nowPage, HttpSession session) {
		// @RequestParam(defaultValue="") 파라미터가 없다면, 기본값을 지정한다
		
		ModelAndView mav = new ModelAndView();
		nowPage = (nowPage == 0) ? 1 : nowPage;
		String keyword = (String)session.getAttribute("keyword");	
		int total;
		PagingDTO paging;
		List<BoardDTO> list;	
		if(keyword == null || keyword.equals("")) {			
			total = boardService.getCount();
			paging = new PagingDTO(total, nowPage);
			list = boardService.getList(paging);			
		}
		else {			
			total = boardService.getCountByKeyword(keyword);			
			paging = new PagingDTO(total, nowPage);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("keyword", keyword);
			map.put("paging", paging);			
			list = boardService.getListByKeyword(map);
		}		
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		
		return mav;
		
	}
	
	@GetMapping("/search")
	public ModelAndView search(String keyword, HttpSession session) {		
		ModelAndView mav = new ModelAndView("redirect:/board/list");
		if(session.getAttribute("keyword") != null) {
			session.removeAttribute("keyword");
		}		
		session.setAttribute("keyword", keyword);
		mav.addObject("nowPage", 0);
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardDTO board, HttpServletRequest request) {
//		System.out.println(request.getRemoteAddr());
		board.setIpaddr(request.getRemoteAddr());
		List<MultipartFile> list = board.getUploadFile();
		list.removeIf(file -> file.getSize() == 0);
		board.setUploadFile(list);		
		int row = boardService.write(board);
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return "redirect:/board/list";		
	}
	
	@GetMapping("/detail/{idx}/{nowPage}")
	public ModelAndView detail(@PathVariable("idx") int idx, @PathVariable("nowPage") int nowPage) {
		ModelAndView mav = new ModelAndView("/board/detail");
		System.out.println(nowPage);
		if(nowPage == 0) nowPage = 1;
		int total = boardService.getCount();
		PagingDTO paging = new PagingDTO(total, nowPage);
		List<BoardDTO> list = boardService.getList(paging);
		List<ReplyDTO> reply_list = boardService.getReply(idx);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.addObject("reply_list", reply_list);
		
		int count = boardService.plusCount(idx);
		System.out.println(count != 0 ? "카운트 성공" : "카운트 실패");
		BoardDTO dto = boardService.getDTO(idx); 
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/add_reply/{idx}/{nowPage}")
	public ModelAndView add_reply(@PathVariable("idx") int idx, @PathVariable("nowPage") int nowPage) {
		ModelAndView mav = new ModelAndView("/board/add_reply");
		BoardDTO dto = boardService.getDTO(idx);
		mav.addObject("dto", dto);		
		return mav;
	}
	
	@PostMapping("/add_reply/{idx}/{nowPage}")
	public String add_reply(ReplyDTO reply, @PathVariable("nowPage") int nowPage) {
		int row = boardService.add_reply(reply);
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return "redirect:/board/detail/" + reply.getReply_board() + "/" + nowPage;
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/modify");		
		BoardDTO dto = boardService.getDTO(idx); 
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public String modify(BoardDTO board) {
		List<MultipartFile> list = board.getUploadFile();
		list.removeIf(file -> file.getSize() == 0);
		board.setUploadFile(list);
		int row = boardService.modify(board);
		System.out.println(row != 0 ? "수정 성공" : "수정 실패");
		return "redirect:/board/detail/" + board.getIdx();
	}
	
	@GetMapping("/remove/{idx}")
	public String remove(@PathVariable("idx") int idx) {
		int row = boardService.remove(idx);
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		return "redirect:/board/list";
	}
}
