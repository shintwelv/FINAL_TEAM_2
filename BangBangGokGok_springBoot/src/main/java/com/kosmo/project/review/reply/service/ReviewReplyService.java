package com.kosmo.project.review.reply.service;

import java.util.List;

import com.kosmo.project.review.reply.model.ReviewReplyVO;

public interface ReviewReplyService {

	List<ReviewReplyVO> getReplies(int articleId);

	ReviewReplyVO getReply(int replyId, int articleId);

	void makeReply(ReviewReplyVO vo);

	void updateReply(ReviewReplyVO vo);

	void deleteReply(ReviewReplyVO vo);

	List<ReviewReplyVO> getAllReplies();

}