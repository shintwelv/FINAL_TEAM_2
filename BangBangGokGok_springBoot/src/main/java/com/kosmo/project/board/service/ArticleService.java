package com.kosmo.project.board.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.board.model.ArticleVO;

public interface ArticleService {

	List<ArticleVO> getArticleByArticleCode(String articleCode);

	ArticleVO getArticleByArticleNo(int articleNo);

	boolean deleteArticle(ArticleVO vo);

	boolean createArticle(ArticleVO vo, MultipartFile file);

	boolean updateArticle(ArticleVO vo, MultipartFile file);

	Page<ArticleVO> getArticleByArticleCodeOfPage(String articleCode, Pageable pageable);

}