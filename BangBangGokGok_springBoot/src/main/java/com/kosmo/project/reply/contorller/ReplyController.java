package com.kosmo.project.reply.contorller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<ReplyVO> getRepliesByArticleNoOfPage(@RequestParam("articleNo") int articleNo, @RequestParam("size") int size, @RequestParam("page") int page) {
		try {
			Page<ReplyVO> replies = service.getRepliesByArticleNoOfPage(articleNo, PageRequest.of(page, size));
			return replies.getContent();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@RequestMapping(value = "insert.do")
	public ReplyVO createReply(ReplyVO vo) {
		try {
			vo.setWriteDate(new Date());
			return service.createReply(vo);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@RequestMapping(value = "modify.do")
	public ReplyVO modifyReply(ReplyVO vo) {
		try {
			vo.setWriteDate(new Date());
			return service.modifyReply(vo);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@RequestMapping(value = "delete.do")
	public boolean deleteReply(ReplyVO vo) {
		try {
			return service.deleteReply(vo);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "deleteReplies.do")
	public boolean deleteReplyOfArticle(@RequestParam("articleNo") int articleNo) {
		System.out.println("articleNo: " + articleNo);
		try {
			service.deleteReplyByArticleNo(articleNo);	
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

}
