package com.kosmo.project.free.reply.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kosmo.project.free.reply.model.FreeReplyVO;

@Repository
public interface FreeReplyRepository extends CrudRepository<FreeReplyVO, Integer>{
	
	List<FreeReplyVO> findAll();
	
	FreeReplyVO findByReplyIdAndArticleId(int replyId, int articleId);
	
	List<FreeReplyVO> findByArticleId(int articleId);
	
	List<FreeReplyVO> findByArticleIdAndReplyWriterId(int articleId, String writerId);
	
	FreeReplyVO save(FreeReplyVO vo);
	
	void delete(FreeReplyVO vo);

}
