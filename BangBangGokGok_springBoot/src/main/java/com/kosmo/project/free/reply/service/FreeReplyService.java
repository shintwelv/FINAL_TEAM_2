package com.kosmo.project.free.reply.service;

import java.util.List;

import com.kosmo.project.free.reply.model.FreeReplyVO;

public interface FreeReplyService {

	List<FreeReplyVO> getReplies(int articleId);

	FreeReplyVO getReply(int replyId, int articleId);

	void makeReply(FreeReplyVO vo);

	void updateReply(FreeReplyVO vo);

	void deleteReply(FreeReplyVO vo);

	List<FreeReplyVO> getAllReplies();

}