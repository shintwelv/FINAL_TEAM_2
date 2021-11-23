package com.kosmo.project.festival.reply.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.festival.reply.model.FestivalReplyVO;
import com.kosmo.project.festival.reply.service.FestivalReplyService;

@RestController
@RequestMapping(value = "/festival/reply")
public class FestivalReplyController {
	
	@Autowired
	private FestivalReplyService service;

	@RequestMapping(value = "/view.do")
	public List<FestivalReplyVO> getAllRepliesOfBoard(FestivalReplyVO vo) {
		List<FestivalReplyVO> replies = service.getReplies(vo.getArticleId());
		return replies;
		
	}
	
	@RequestMapping(value = "/insertProcess.do")
	public boolean insertProcess(FestivalReplyVO vo) {
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
	public boolean updateProcess(FestivalReplyVO vo) {
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
	public boolean deleteProcess(FestivalReplyVO vo) {
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
		List<FestivalReplyVO> allReplies = service.getReplies(articleId);
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
