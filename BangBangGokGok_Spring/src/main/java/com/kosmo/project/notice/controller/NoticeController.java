package com.kosmo.project.notice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.notice.impl.NoticeService;
import com.kosmo.project.notice.model.NoticeVO;
import com.kosmo.project.util.Constants;
import com.oreilly.servlet.MultipartRequest;

@RestController
@RequestMapping(value = "/notice")
@CrossOrigin
public class NoticeController {
	private int startPoint = 1;
	private int endPoint = 5;
	
	@Autowired NoticeService service;
	
	private static final String NOTICE_IMAGE_FOLDER = Constants.DEFAULT_DIR;
	
//	사진 저장 폴더가 없을 시 생성
	public NoticeController() {
		Path path = Paths.get(NOTICE_IMAGE_FOLDER);
		try {
			Files.createDirectories(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	@requestbody 필요
	
	
	@RequestMapping(value = "insertProcess.do")
	public boolean insert(NoticeVO vo , HttpServletRequest request) {
		try {
			NoticeVO voToInsert = setNoticeByMultiRequest(vo, request);
			service.insert(voToInsert);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	@RequestMapping(value = "updateProcess.do")
	public boolean update(NoticeVO vo, HttpServletRequest request) {
		try {
			NoticeVO voToUpdate = setNoticeByMultiRequest(vo, request);
			service.update(voToUpdate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@RequestMapping(value = "select.do")
	public NoticeVO select(NoticeVO vo, HttpServletRequest request) {
		try {
			service.countUp(vo);
			NoticeVO notice = service.select(vo);
			return notice;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	@RequestMapping(value = "deleteProcess.do")
	public boolean delete(NoticeVO vo, HttpServletRequest request) {
		try {
			NoticeVO voToUpdate = setNoticeByMultiRequest(vo, request);
			service.delete(voToUpdate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "pageNationJobArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) throws Exception {
		throw new Exception("페이지네이션을 서버에서 처리할지, 프론트에서 처리할지 정하지 못했음");
		
//		int totalPage = service.totalPage();
//		String arrowDirection = request.getParameter("arrowDirection");
//		if (arrowDirection != null) {
//			if (arrowDirection.trim().equals("left")) {
//				calculateLeftArrow();
//			} else if (arrowDirection.trim().equals("right")) {
//				calculateRightArrow(totalPage);
//			}
//		}
//		String pageNum = request.getParameter("pageNum");
//		int pageNumVal = startPoint;
//		if (pageNum != null && !pageNum.trim().equals("")) {
//			pageNumVal = Integer.parseInt(pageNum);
//		}
//		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("startPoint", startPoint);
//		model.addAttribute("endPoint", endPoint);
//		
//		List<NoticeVO> articleList = null;
//		articleList = service.pageNationNotice(pageNumVal);
//		model.addAttribute("ArticleList", articleList);
//		return "list";
	}
	
	private void calculateLeftArrow() {
		if (startPoint - 5 >= 1) {
			endPoint = startPoint - 1;
			startPoint = startPoint - 5;
		}
	}
	
	private void calculateRightArrow(int totalPage) {
		if (startPoint + 5 <= totalPage) {
			startPoint = startPoint + 5;
		}
		if (endPoint + 5 < totalPage) {
			endPoint = endPoint + 5;
		} else {
			endPoint = totalPage;
		}
	}
	
	private NoticeVO setNoticeByMultiRequest(NoticeVO vo, HttpServletRequest request) {
		MultipartRequest multiRequest;
		
		try {
			multiRequest = new MultipartRequest(request, System.getProperty("user.dir")+NOTICE_IMAGE_FOLDER, 1024*1024*100, "utf-8");
			try {
				vo.setArticle_no(Integer.parseInt(multiRequest.getParameter("article_no")));
			} catch (Exception e) {
			}
			vo.setArticle_title(multiRequest.getParameter("article_title"));
			vo.setArticle_content(multiRequest.getParameter("article_content"));
			vo.setUser_id(multiRequest.getParameter("user_id"));
			vo.setArticle_image("./resources/images/" + multiRequest.getOriginalFileName("article_image"));
			return vo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
