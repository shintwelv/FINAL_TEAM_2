package com.kosmo.project.reply.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kosmo.project.reply.model.ReplyVO;

public interface ReplyService {

	Page<ReplyVO> getRepliesByArticleNoOfPage(int articleNo, Pageable pageable);

	ReplyVO createReply(ReplyVO vo);

	ReplyVO modifyReply(ReplyVO vo);

	boolean deleteReply(ReplyVO vo);

	boolean deleteReplyByArticleNo(int articleNo);

}