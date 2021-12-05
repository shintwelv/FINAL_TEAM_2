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
	
	public TmpBoard findByTransferId(int transferId);
	
	public List<TmpBoard> findAll(Sort sort);
	
	public Page<TmpBoard> findAll(Pageable pageable);
	
	public void delete(Integer transferId);
	
	public List<TmpBoard> findByTransferName(String transferName);       // 게시글 제목 검색
	
	public List<TmpBoard> findByTransferContent(String transferContent);       // 게시글 내용 검색
	
	public List<TmpBoard> findByTransferWriterId(String transferWriterId);          // 게시글 작성자 검색
}
