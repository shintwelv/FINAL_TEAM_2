package com.kosmo.project.board.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.board.model.ArticleVO;
import com.kosmo.project.board.service.ArticleService;
import com.kosmo.project.util.Constants;

@RestController
@CrossOrigin
@RequestMapping(value = "/article")
public class ArticleController {
	@Autowired
	private ArticleService service;
	
//	이 위치에 게시글의 사진 저장
	private static final String FESTIVAL_IMAGE_LOCATION = Constants.DEFAULT_DIR;
	
//	축제 게시글 사진 저장 폴더가 없을 시 생성
	public ArticleController(){
		Path path = Paths.get(FESTIVAL_IMAGE_LOCATION);
		try {
			Files.createDirectories(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "list.do")
	public List<ArticleVO> getArticlesByArticleCode(String articleCode) {
		List<ArticleVO> articles = service.getArticleByArticleCode(articleCode);
		
		return articles;
	}
	
	@RequestMapping(value = "page.do")
	public List<ArticleVO> getArticleByArticleCodeOfPage(@RequestParam("articleCode") String articleCode, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		System.out.println("articleCode: " + articleCode + "\n" + "page: " + page + "\n" + "size: " + size);
		Page<ArticleVO> articles = service.getArticleByArticleCodeOfPage(articleCode, PageRequest.of(page, size));
		
		return articles.getContent();
	}
	
	@RequestMapping(value = "insert.do")
	public boolean createArticle(ArticleVO vo, @RequestParam("Image") MultipartFile file) {
		System.out.println(file);
		try {
			vo.setWriteDate(new Date());
			service.createArticle(vo, file);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "update.do")
	public boolean updateArticle(ArticleVO vo, MultipartFile file) {
		try {
			vo.setWriteDate(new Date());
			service.updateArticle(vo, file);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "delete.do")
	public boolean deleteArticle(ArticleVO vo) {
		System.out.println(vo);
		try {
			service.deleteArticle(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "view.do")
	public ArticleVO getArticle(@RequestParam("articleNo") int articleNo) {
		try {
			countUp(articleNo);
			return service.getArticleByArticleNo(articleNo);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	@RequestMapping(value = "getArticleNum.do")
	public Integer getArticleNum(@RequestParam("articleCode") String articleCode) {
		List<ArticleVO> articles = service.getArticleByArticleCode(articleCode);
		
		return articles.size();
		
	}
	
	private void countUp(int articleNo) {
		ArticleVO article = service.getArticleByArticleNo(articleNo);
		article.setViewCount(article.getViewCount()+1);
		service.updateArticle(article, null);
	}

}
