package com.kosmo.project.boardtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kosmo.project.boardtest.tmpboard.TmpBoard;
import com.kosmo.project.boardtest.tmpboard.TmpBoardRepository;

@Service("TmpBoardService")
public class TmpBoardServiceImpl implements TmpBoardService{

	@Autowired
	private TmpBoardRepository tbr;
	
	@Override
	public TmpBoard save(TmpBoard tb) {
		return tbr.save(tb);
	}

	@Override
	public List<TmpBoard> findAll(Sort sort) {
		return tbr.findAll(sort);
	}

	@Override
	public TmpBoard findByTransferId(int articleNo) {
		return tbr.findByArticleNo(articleNo);
	}

	@Override
	public void delete(int transferId) {
		tbr.delete(transferId);
	}

	@Override
	public Page<TmpBoard> findAll(Pageable pageable) {
		return tbr.findAll(pageable);
	}

}
