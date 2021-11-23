package com.kosmo.project.festival.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.project.festival.reply.model.FestivalReplyVO;
import com.kosmo.project.festival.reply.repository.FestivalReplyRepository;


@Service
public class FestivalReplyServiceImpl implements FestivalReplyService{
	@Autowired
	private FestivalReplyRepository repo;
	
	@Override
	public List<FestivalReplyVO> getAllReplies() {
		return repo.findAll();
	}
	
	@Override
	public List<FestivalReplyVO> getReplies(int articleId) {
		return repo.findByArticleId(articleId);
	}
	
	@Override
	public FestivalReplyVO getReply(int replyId, int articleId) {
		return repo.findByReplyIdAndArticleId(replyId, articleId);
	}
	
	
	@Override
	public void makeReply(FestivalReplyVO vo) {
		repo.save(vo);
	}
	
	@Override
	public void updateReply(FestivalReplyVO vo) {
		repo.save(vo);
	}
	
	@Override
	public void deleteReply(FestivalReplyVO vo) {
		repo.delete(vo);
	}

}
