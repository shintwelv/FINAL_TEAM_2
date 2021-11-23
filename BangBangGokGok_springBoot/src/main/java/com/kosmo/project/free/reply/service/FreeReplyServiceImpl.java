package com.kosmo.project.free.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.project.free.reply.model.FreeReplyVO;
import com.kosmo.project.free.reply.repository.FreeReplyRepository;


@Service
public class FreeReplyServiceImpl implements FreeReplyService{
	@Autowired
	private FreeReplyRepository repo;
	
	@Override
	public List<FreeReplyVO> getAllReplies() {
		return repo.findAll();
	}
	
	@Override
	public List<FreeReplyVO> getReplies(int articleId) {
		return repo.findByArticleId(articleId);
	}
	
	@Override
	public FreeReplyVO getReply(int replyId, int articleId) {
		return repo.findByReplyIdAndArticleId(replyId, articleId);
	}
	
	
	@Override
	public void makeReply(FreeReplyVO vo) {
		repo.save(vo);
	}
	
	@Override
	public void updateReply(FreeReplyVO vo) {
		repo.save(vo);
	}
	
	@Override
	public void deleteReply(FreeReplyVO vo) {
		repo.delete(vo);
	}

}
