package com.kosmo.project.reply.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kosmo.project.reply.model.ReplyVO;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyVO, Integer>{
	
	ReplyVO findByReplyNo(int replyNo);
	
	Page<ReplyVO> findByArticleNoOrderByWriteDateDesc(int articleNo, Pageable pageable);
	
	@Transactional
	List<ReplyVO> deleteByArticleNo(int articleNo);

}
