package com.kosmo.project.review.reply.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.review.board.model.Review;
import com.kosmo.project.review.board.service.ReviewService;
import com.kosmo.project.review.reply.model.ReviewReplyVO;
import com.kosmo.project.review.reply.service.ReviewReplyService;

@RestController
@RequestMapping(value = "/review/reply")
@CrossOrigin
public class ReviewReplyController {

	@Autowired
	private ReviewReplyService replyService;
	@Autowired
	private ReviewService boardService;

	@RequestMapping(value = "/view.do")
	public List<ReviewReplyVO> getAllRepliesOfBoard(ReviewReplyVO vo) {
		List<ReviewReplyVO> replies = replyService.getReplies(vo.getArticleId());
		return replies;
		
	}
	
	@RequestMapping(value = "/insertProcess.do")
	public boolean insertProcess(ReviewReplyVO vo) {
		try {
			vo.setReplyDate(new Date());
			replyService.makeReply(vo);
			Review board = boardService.getReview(vo.getArticleId());
			board.setReviewStar(getAvgStar(board.getReviewId()));
			boardService.updateReview(board.getReviewId(), board);
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
			replyService.updateReply(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "/deleteProcess.do")
	public boolean deleteProcess(ReviewReplyVO vo) {
		try {
			replyService.deleteReply(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
//	Pagination
	private int getReplyCount(int articleId) {
		List<ReviewReplyVO> allReplies = replyService.getReplies(articleId);
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
	
	//평균 별점 계산
	private double getAvgStar(int boardId) {
		double totalStarPoint = 0.0;
		int reviewNum = 0;
		double avgStarPoint = 0.0;
		List<ReviewReplyVO> repliesOfBoard = replyService.getReplies(boardId);
		for (Iterator iterator = repliesOfBoard.iterator(); iterator.hasNext();) {
			ReviewReplyVO reply = (ReviewReplyVO) iterator.next();
			totalStarPoint += reply.getReplyRating();
			reviewNum += 1;
		}
		
		avgStarPoint = totalStarPoint/reviewNum;
		return avgStarPoint;
	}

}
