package com.kosmo.project.free.reply.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.project.free.reply.model.FreeReplyVO;
import com.kosmo.project.free.reply.service.FreeReplyService;

@Controller
@RequestMapping(value = "/free")
public class FreeReplyController {

	@Autowired
	private FreeReplyService service;

	@RequestMapping(value = {"/", "/main"})
	public ModelAndView goMain() {
		List<FreeReplyVO> replies = service.getAllReplies();
		ModelAndView mv = new ModelAndView("main");
		mv.addObject("replies", replies);
		return mv;
	}

	@RequestMapping(value = "/insert.do")
	public String fwdInsert() {
		return "insert";
	}

	@RequestMapping(value = "/update.do")
	public ModelAndView fwdUpdate(HttpServletRequest request) {
		ModelAndView mv = getMV(request);

		mv.setViewName("update");
		return mv;
	}

	@RequestMapping(value = "/delete.do")
	public ModelAndView fwdDelete(HttpServletRequest request) {
		ModelAndView mv = getMV(request);

		mv.setViewName("delete");
		return mv;
	}

	@RequestMapping(value = "/view.do")
	public ModelAndView fwdView(HttpServletRequest request) {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		int totalPage = getReplyPageNum(articleId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		List<FreeReplyVO> replies = service.getReplies(articleId);

		mv.addObject("replies", replies);
		mv.addObject("totalPage", totalPage);
		return mv;
	}

	private ModelAndView getMV(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		int replyId = Integer.parseInt(request.getParameter("replyId"));

		FreeReplyVO reply = service.getReply(replyId, articleId);

		mv.addObject("reply", reply);

		return mv;
	}
	
	@RequestMapping(value = "/insertProcess.do")
	public ModelAndView insertProcess(FreeReplyVO vo) {
		
		vo.setReplyDate(new Date());
		
		service.makeReply(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:main");
		
		return mv;
	}
	
	@RequestMapping(value = "/updateProcess.do")
	public ModelAndView updateProcess(FreeReplyVO vo) {
		vo.setReplyDate(new Date());
		service.updateReply(vo);
		
		ModelAndView mv = new ModelAndView("redirect:main");
		
		return mv;
	}
	
	@RequestMapping(value = "/deleteProcess.do")
	public ModelAndView deleteProcess(FreeReplyVO vo) {
		service.deleteReply(vo);
		
		ModelAndView mv = new ModelAndView("redirect:main");
		
		return mv;
	}
	
//	Pagination
	private int getReplyCount(int articleId) {
		List<FreeReplyVO> allReplies = service.getReplies(articleId);
		return allReplies.size();
	}
	
	private int getReplyPageNum(int articleId) {
//		한 페이지에 댓글이 5개씩 보이는 경우
		int replyCount = getReplyCount(articleId);
		int totalPage = replyCount/5;
		if (totalPage * 5 < replyCount) {
			totalPage++;
		}
		
		return totalPage;
	}

}
