package com.kosmo.project.review.reply.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.review.reply.model.ReviewReplyVO;
import com.kosmo.project.review.reply.service.ReviewReplyService;

@RestController
@RequestMapping(value = "/review/reply")
@CrossOrigin
public class ReviewReplyController {

	@Autowired
	private ReviewReplyService service;

	@RequestMapping(value = "/view.do")
	public List<ReviewReplyVO> getAllRepliesOfBoard(ReviewReplyVO vo) {
		List<ReviewReplyVO> replies = service.getReplies(vo.getArticleId());
		return replies;
		
	}
	
	@RequestMapping(value = "/insertProcess.do")
	public boolean insertProcess(ReviewReplyVO vo) {
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
	public boolean updateProcess(ReviewReplyVO vo) {
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
	public boolean deleteProcess(ReviewReplyVO vo) {
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
		List<ReviewReplyVO> allReplies = service.getReplies(articleId);
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
