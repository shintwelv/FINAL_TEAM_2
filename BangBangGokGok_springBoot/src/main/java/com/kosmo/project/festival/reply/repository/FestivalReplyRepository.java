package com.kosmo.project.festival.reply.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kosmo.project.festival.reply.model.FestivalReplyVO;

@Repository
public interface FestivalReplyRepository extends CrudRepository<FestivalReplyVO, Integer>{
	
	List<FestivalReplyVO> findAll();
	
	FestivalReplyVO findByReplyIdAndArticleId(int replyId, int articleId);
	
	List<FestivalReplyVO> findByArticleId(int articleId);
	
	List<FestivalReplyVO> findByArticleIdAndReplyWriterId(int articleId, String writerId);
	
	FestivalReplyVO save(FestivalReplyVO vo);
	
	void delete(FestivalReplyVO vo);

}
