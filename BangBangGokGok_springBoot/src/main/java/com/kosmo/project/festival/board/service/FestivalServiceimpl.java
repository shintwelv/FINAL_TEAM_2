package com.kosmo.project.festival.board.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.festival.board.model.FestivalVO;
import com.kosmo.project.festival.board.repository.FestivalRepository;
import com.kosmo.project.festival.util.Constants;

@Service
public class FestivalServiceimpl implements FestivalService{
	@Autowired 
	private FestivalRepository festi;
	
	@Override
	public List<FestivalVO> getAllFestival(){
		return festi.findAll();
	}
	
	@Override
	public FestivalVO getFindFestival(int festivalId){
		return festi.findByFestivalId(festivalId);
	}
	
	@Override
	public void updateFestival(FestivalVO vo, MultipartFile file) throws Exception{ 
		String projectPath = Constants.FESTIVAL_IMAGE_LOCATION;
		
		
		String fileName = file.getOriginalFilename();
		
		File saveFile = new File(projectPath, fileName);
		
		file.transferTo(saveFile);
		
		vo.setFestivalImage("/festival_image_location/"+fileName);
		
		festi.save(vo);
	}
	
	@Override
	public void deleteFestival(FestivalVO vo) {
		festi.delete(vo);
	}
	//글 작성 처리
	@Override
	public void insertFestival(FestivalVO vo, MultipartFile file) throws Exception{
		String projectPath = Constants.FESTIVAL_IMAGE_LOCATION;
		
		
		String fileName = file.getOriginalFilename();
		
		File saveFile = new File(projectPath, fileName);
		
		file.transferTo(saveFile);
		
		vo.setFestivalImage("/festival_image_location/"+fileName);
		
		festi.save(vo);
	}
	
	@Override
	public List<FestivalVO> boardSearchList(String searchKeyword) {
		
		return festi.findByfestivalNameContaining(searchKeyword);
		
	}
	
	
}
