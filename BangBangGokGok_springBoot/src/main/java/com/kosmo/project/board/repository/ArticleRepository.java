package com.kosmo.project.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosmo.project.board.model.ArticleVO;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleVO, Integer>{
	
	List<ArticleVO> findByArticleCodeOrderByWriteDateDesc(String articleCode);
	
	ArticleVO findByArticleNo(int articleNo);
	
	Page<ArticleVO> findByArticleCodeOrderByWriteDateDesc(String articleCode, Pageable pageable);

}
