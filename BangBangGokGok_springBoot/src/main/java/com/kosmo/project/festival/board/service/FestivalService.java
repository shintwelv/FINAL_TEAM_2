package com.kosmo.project.festival.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.festival.board.model.FestivalVO;

public interface FestivalService {

	List<FestivalVO> getAllFestival();

	FestivalVO getFindFestival(int festivalId);

	void updateFestival(FestivalVO vo, MultipartFile file) throws Exception;

	void deleteFestival(FestivalVO vo);

	//글 작성 처리
	void insertFestival(FestivalVO vo, MultipartFile file) throws Exception;

	List<FestivalVO> boardSearchList(String searchKeyword);

}