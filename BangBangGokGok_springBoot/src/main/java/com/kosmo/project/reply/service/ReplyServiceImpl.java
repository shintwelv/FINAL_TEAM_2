package com.kosmo.project.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kosmo.project.reply.model.ReplyVO;
import com.kosmo.project.reply.repository.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyRepository repo;
	
	@Override
	public Page<ReplyVO> getRepliesByArticleNoOfPage(int articleNo, Pageable pageable) {
		try {
			return repo.findByArticleNoOrderByWriteDateDesc(articleNo, pageable);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public ReplyVO createReply(ReplyVO vo) {
		try {
			return repo.save(vo);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public ReplyVO modifyReply(ReplyVO vo) {
		try {
			return repo.save(vo);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public boolean deleteReply(ReplyVO vo) {
		try {
			repo.deleteById(vo.getReplyNo());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
