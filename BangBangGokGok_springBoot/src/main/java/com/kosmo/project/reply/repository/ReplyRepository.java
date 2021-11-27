package com.kosmo.project.reply.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosmo.project.reply.model.ReplyVO;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyVO, Integer>{
	
	ReplyVO findByReplyNo(int replyNo);
	
	Page<ReplyVO> findByArticleNoOrderByWriteDateDesc(int articleNo, Pageable pageable);

}
