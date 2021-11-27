package com.kosmo.project.reply.contorller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.reply.model.ReplyVO;
import com.kosmo.project.reply.service.ReplyService;

@RestController
@CrossOrigin
@RequestMapping(value = "/reply")
public class ReplyController {
	@Autowired
	private ReplyService service;

	@RequestMapping(value = "page.do")
	public List<ReplyVO> getRepliesByArticleNoOfPage(int articleNo, int size, int page) {
		try {
			Page<ReplyVO> replies = service.getRepliesByArticleNoOfPage(articleNo, PageRequest.of(page, size));
			return replies.getContent();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@RequestMapping(value = "insert.do")
	public boolean createReply(ReplyVO vo) {
		try {
			vo.setWriteDate(new Date());
			service.createReply(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "modify.do")
	public boolean modifyReply(ReplyVO vo) {
		try {
			vo.setWriteDate(new Date());
			service.modifyReply(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "delete.do")
	public boolean deleteReply(ReplyVO vo) {
		try {
			service.deleteReply(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
