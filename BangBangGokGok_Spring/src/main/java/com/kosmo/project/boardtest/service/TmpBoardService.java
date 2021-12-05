package com.kosmo.project.boardtest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.kosmo.project.boardtest.tmpboard.TmpBoard;

public interface TmpBoardService {
	public TmpBoard save(TmpBoard tb);
	
	public TmpBoard findByTransferId(int transferId);
	
	public List<TmpBoard> findAll(Sort sort);
	
	public void delete(int transferId);
	
	public Page<TmpBoard> findAll(Pageable pageable);
}
