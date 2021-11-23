package com.kosmo.project.free.reply.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.free.reply.model.FreeReplyVO;
import com.kosmo.project.free.reply.service.FreeReplyService;

@RestController
@RequestMapping(value = "/free/reply")
@CrossOrigin
public class FreeReplyController {

	@Autowired
	private FreeReplyService service;

	@RequestMapping(value = "/view.do")
	public List<FreeReplyVO> getAllRepliesOfBoard(FreeReplyVO vo) {
		List<FreeReplyVO> replies = service.getReplies(vo.getArticleId());
		return replies;
		
	}
	
	@RequestMapping(value = "/insertProcess.do")
	public boolean insertProcess(FreeReplyVO vo) {
		try {
			vo.setReplyDate(new Date());
			service.makeReply(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "/updateProcess.do")
	public boolean updateProcess(FreeReplyVO vo) {
		try {
			vo.setReplyDate(new Date());
			service.updateReply(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "/deleteProcess.do")
	public boolean deleteProcess(FreeReplyVO vo) {
		try {
			service.deleteReply(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
//	Pagination
	private int getReplyCount(int articleId) {
		List<FreeReplyVO> allReplies = service.getReplies(articleId);
		return allReplies.size();
	}
	
	private int getReplyPageNum(int articleId) {
//		한 페이지에 댓글이 5개씩 보이는 경우
		int replyCount = getReplyCount(articleId);
		int totalPage = replyCount/5;
		if (totalPage * 5 < replyCount) {
			totalPage++;
		}
		
		return totalPage;
	}

}
