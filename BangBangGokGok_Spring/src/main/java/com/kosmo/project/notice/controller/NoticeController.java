package com.kosmo.project.notice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.notice.impl.NoticeService;
import com.kosmo.project.notice.model.NoticeVO;
import com.kosmo.project.util.Constants;
import com.oreilly.servlet.MultipartRequest;

@RestController
@RequestMapping(value = "/notice")
public class NoticeController {
	
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
	
	
	@RequestMapping(value = "insert.do")
	public boolean insert(NoticeVO vo , HttpServletRequest request) {
		try {
			NoticeVO voToInsert = setNoticeByMultiRequest(vo, request);
			System.out.println(voToInsert);
			service.insert(voToInsert);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	@RequestMapping(value = "update.do")
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
	
	
	@RequestMapping(value = "delete.do")
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
	
	@RequestMapping(value = "pageNation.do")
	public List<NoticeVO> pageNationArticleList(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		try {
			List<NoticeVO> articleList = service.pageNationNotice(page, size);
			return articleList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "getArticleNum.do")
	public Integer getArticleNum() {
		List<NoticeVO> articles = service.selectArticleList();
		return articles.size();
	}
	
	private NoticeVO setNoticeByMultiRequest(NoticeVO vo, HttpServletRequest request) {
		MultipartRequest multiRequest;
		
		try {
			multiRequest = new MultipartRequest(request, NOTICE_IMAGE_FOLDER, 1024*1024*100, "utf-8");
			try {
				vo.setArticleNo(Integer.parseInt(multiRequest.getParameter("articleNo")));
			} catch (Exception e) {
			}
			vo.setArticleCode(multiRequest.getParameter("articleCode"));
			vo.setArticleTitle(multiRequest.getParameter("articleTitle"));
			vo.setArticleContent(multiRequest.getParameter("articleContent"));
			vo.setUserId(multiRequest.getParameter("userId"));
			vo.setArticleImage("./resources/images/" + multiRequest.getOriginalFileName("articleImage"));
			return vo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
