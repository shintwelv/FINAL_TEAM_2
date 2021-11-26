package com.kosmo.project.free.board.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.free.board.model.FreeVO;
import com.kosmo.project.free.board.service.FreeService;
import com.kosmo.project.util.Constants;

@RestController
@CrossOrigin
@RequestMapping(value = "/free")
public class FreeController {
	
	@Autowired
	private FreeService service;
	
	private static final String FREE_IMAGE_LOCATION = Constants.DEFAULT_DIR + "free";
	
	public FreeController(){
		Path path = Paths.get(FREE_IMAGE_LOCATION);
		try {
			Files.createDirectories(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "list.do")
	public List<FreeVO> getAllBoards() {
		List<FreeVO> boardList = null;
		boardList = service.getAllFree();

		return boardList;
	}
	
	@RequestMapping(value = "insertProcess.do")
	public boolean insertProcess(FreeVO vo, MultipartFile file) throws Exception {
		try {
			service.insertFree(vo,file);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@RequestMapping(value = "updateProcess.do")
	public boolean updateProcess(FreeVO vo, MultipartFile file) throws Exception {
		try {
			service.updateFree(vo,file);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@RequestMapping(value = "deleteProcess.do")
	public boolean deleteProcess(FreeVO vo) {
		try {
			service.deleteFree(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "view.do")
	public FreeVO getBoard(FreeVO vo) {
		try {
			FreeVO board = service.getFree(vo.getFreeId());
			return board;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
//		
//	private int getPageCount() {
//		List<FreeVO> allPage = service.getAllFree();
//		return allPage.size();
//	}
//	
//	private int getFreePageNum(int articlesPerPage) {
////		한 페이지에 게시글이 5개 보이도록 처리
//		int FreeCount = getPageCount();
//		int totalPage = FreeCount/articlesPerPage;
//		if (totalPage * articlesPerPage < FreeCount) {
//			totalPage++;
//		}
//		
//		return totalPage;
//	}
}
