package com.kosmo.project.festival.board.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.festival.board.model.FestivalVO;
import com.kosmo.project.festival.board.service.FestivalService;
import com.kosmo.project.festival.util.Constants;

@RestController
@RequestMapping(value = "/festival")
@CrossOrigin
public class FestivalController {
	@Autowired FestivalService service;
	
//	이 위치에 축제 게시글의 사진 저장
	private static final String FESTIVAL_IMAGE_LOCATION = Constants.FESTIVAL_IMAGE_LOCATION;
	
//	축제 게시글 사진 저장 폴더가 없을 시 생성
	public FestivalController(){
		Path path = Paths.get(FESTIVAL_IMAGE_LOCATION);
		try {
			Files.createDirectories(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = {"/", "list.do"})
	public List<FestivalVO> getAllBoards() {
		List<FestivalVO> boardList = null;
		boardList = service.getAllFestival();

		return boardList;
	}
	
	@RequestMapping(value = "insertProcess.do")
	public boolean insertProcess(FestivalVO vo, MultipartFile file) throws Exception {
		vo.setFestivalstartDate(new Date());
		vo.setFestivalendDate(new Date());
		try {
			service.insertFestival(vo,file);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@RequestMapping(value = "updateProcess.do")
	public boolean updateProcess(FestivalVO vo, MultipartFile file) throws Exception {
		vo.setFestivalstartDate(new Date());
		vo.setFestivalendDate(new Date());
		try {
			service.updateFestival(vo,file);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@RequestMapping(value = "deleteProcess.do")
	public boolean deleteProcess(FestivalVO vo) {
		try {
			service.deleteFestival(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "view.do")
	public FestivalVO getBoard(FestivalVO vo) {
		try {
			FestivalVO board = service.getFindFestival(vo.getFestivalId());
			return board;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
//		
//	private int getPageCount() {
//		List<FestivalVO> allPage = service.getAllFestival();
//		return allPage.size();
//	}
//	
//	private int getFestivalPageNum(int articlesPerPage) {
////		한 페이지에 게시글이 5개 보이도록 처리
//		int festivalCount = getPageCount();
//		int totalPage = festivalCount/articlesPerPage;
//		if (totalPage * articlesPerPage < festivalCount) {
//			totalPage++;
//		}
//		
//		return totalPage;
//	}
	
}
