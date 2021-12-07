package com.kosmo.project.boardtest.tmpboard;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TmpBoardRepository extends JpaRepository<TmpBoard, Integer>{
	public TmpBoard save(TmpBoard tb);
	
	public TmpBoard findByArticleNo(int articleNo);
	
	public List<TmpBoard> findAll(Sort sort);
	
	public Page<TmpBoard> findAll(Pageable pageable);
	
	public void delete(Integer articleNo);
	
	public List<TmpBoard> findByArticleTitle(String articleTitle);       // 게시글 제목 검색
	
	public List<TmpBoard> findByArticleContent(String articleContent);       // 게시글 내용 검색
	
	public List<TmpBoard> findByUserId(String userId);          // 게시글 작성자 검색
}
