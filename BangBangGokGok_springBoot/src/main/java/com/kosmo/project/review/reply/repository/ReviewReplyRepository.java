package com.kosmo.project.review.reply.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kosmo.project.review.reply.model.ReviewReplyVO;

@Repository
public interface ReviewReplyRepository extends CrudRepository<ReviewReplyVO, Integer>{
	
	List<ReviewReplyVO> findAll();
	
	ReviewReplyVO findByReplyIdAndArticleId(int replyId, int articleId);
	
	List<ReviewReplyVO> findByArticleId(int articleId);
	
	List<ReviewReplyVO> findByArticleIdAndReplyWriterId(int articleId, String writerId);
	
	ReviewReplyVO save(ReviewReplyVO vo);
	
	void delete(ReviewReplyVO vo);

}
