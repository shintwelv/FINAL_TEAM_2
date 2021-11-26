package com.kosmo.project.free.board.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.free.board.model.FreeVO;

public interface FreeService {
	
		List<FreeVO> getFreeList(int freeId);
	
		FreeVO getFree(int freeId);

		void insertFree(FreeVO vo, MultipartFile file) throws Exception;

		void updateFree(FreeVO vo,MultipartFile file) throws Exception;

		void deleteFree(FreeVO vo);

		List<FreeVO> getAllFree();
		
		List<FreeVO> freeSearchList(String serchKeyword);
		}
		


