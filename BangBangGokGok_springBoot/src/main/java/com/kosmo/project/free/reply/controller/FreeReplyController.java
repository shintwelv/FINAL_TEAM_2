package com.kosmo.project.free.reply.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.free.board.model.FreeVO;
import com.kosmo.project.free.board.service.FreeService;
import com.kosmo.project.free.reply.model.FreeReplyVO;
import com.kosmo.project.free.reply.service.FreeReplyService;
import com.kosmo.project.review.reply.model.ReviewReplyVO;

@RestController
@RequestMapping(value = "/free/reply")
@CrossOrigin
public class FreeReplyController {

	@Autowired
	private FreeReplyService replyService;
	@Autowired
	private FreeService boardService;

	@RequestMapping(value = "/view.do")
	public List<FreeReplyVO> getAllRepliesOfBoard(FreeReplyVO vo) {
		List<FreeReplyVO> replies = replyService.getReplies(vo.getArticleId());
		return replies;

	}

	@RequestMapping(value = "/insertProcess.do")
	public boolean insertProcess(FreeReplyVO vo) {
		try {
			vo.setReplyDate(new Date());
			replyService.makeReply(vo);
			FreeVO board = boardService.getFree(vo.getArticleId());
			board.setFreeStar(getAvgStar(board.getFreeId()));
			boardService.updateFree(board, null);
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
			replyService.updateReply(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@RequestMapping(value = "/deleteProcess.do")
	public boolean deleteProcess(FreeReplyVO vo) {
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
		List<FreeReplyVO> allReplies = replyService.getReplies(articleId);
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
		List<FreeReplyVO> repliesOfBoard = replyService.getReplies(boardId);
		for (Iterator iterator = repliesOfBoard.iterator(); iterator.hasNext();) {
			ReviewReplyVO reply = (ReviewReplyVO) iterator.next();
			totalStarPoint += reply.getReplyRating();
			reviewNum += 1;
		}

		avgStarPoint = totalStarPoint/reviewNum;
		return avgStarPoint;
	}

}
