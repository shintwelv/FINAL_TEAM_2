package com.kosmo.project.review.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.project.review.reply.model.ReviewReplyVO;
import com.kosmo.project.review.reply.repository.ReviewReplyRepository;


@Service
public class ReviewReplyServiceImpl implements ReviewReplyService{
	@Autowired
	private ReviewReplyRepository repo;
	
	@Override
	public List<ReviewReplyVO> getAllReplies() {
		return repo.findAll();
	}
	
	@Override
	public List<ReviewReplyVO> getReplies(int articleId) {
		return repo.findByArticleId(articleId);
	}
	
	@Override
	public ReviewReplyVO getReply(int replyId, int articleId) {
		return repo.findByReplyIdAndArticleId(replyId, articleId);
	}
	
	
	@Override
	public void makeReply(ReviewReplyVO vo) {
		repo.save(vo);
	}
	
	@Override
	public void updateReply(ReviewReplyVO vo) {
		repo.save(vo);
	}
	
	@Override
	public void deleteReply(ReviewReplyVO vo) {
		repo.delete(vo);
	}

}
