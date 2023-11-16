package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.ReplyDTO;
import com.itbank.service.MemberService;
import com.itbank.service.ReplyService;

@RestController
public class AjaxController {
	
	@Autowired private MemberService memberService;
	
	@Autowired private ReplyService replyService;
	
	@GetMapping(value="/member/dupCheck/{inputId}", produces="plain/text;charset=utf-8")
	public String dupCheck(@PathVariable("inputId") String inputId) {
		
		int row = memberService.dupCheck(inputId);
		String msg = row == 1 ? "이미 사용중인 ID입니다" : "사용 가능한 ID입니다";
		msg = row + ":" + msg;
		return msg;
	}
	
	@GetMapping("/board/reply/{board_idx}")
	public List<ReplyDTO> getReply(@PathVariable("board_idx") int idx) {
		List<ReplyDTO> list = replyService.getReply(idx);
		return list;
	}
	
	@PostMapping("/board/reply/{board_idx}")
	public int writeReply(@RequestBody ReplyDTO dto) {
		int row = replyService.writeReply(dto);
		return row;
	}
	
	@DeleteMapping("/board/reply/{board_idx}/{idx}")
	public int deleteReply(@PathVariable("idx") int idx) {
		int row = 0;
		System.out.println("삭제할 댓글 idx : " + idx);
		return row;
	}
}
