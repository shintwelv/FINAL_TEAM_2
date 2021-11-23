package com.kosmo.project.festival.reply.service;

import java.util.List;

import com.kosmo.project.festival.reply.model.FestivalReplyVO;

public interface FestivalReplyService {

	List<FestivalReplyVO> getReplies(int articleId);

	FestivalReplyVO getReply(int replyId, int articleId);

	void makeReply(FestivalReplyVO vo);

	void updateReply(FestivalReplyVO vo);

	void deleteReply(FestivalReplyVO vo);

	List<FestivalReplyVO> getAllReplies();

}