package com.kosmo.project.festival.board.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.festival.board.model.FestivalVO;
import com.kosmo.project.festival.board.repository.FestivalRepository;
import com.kosmo.project.util.Constants;

@Service
public class FestivalServiceimpl implements FestivalService{
	@Autowired 
	private FestivalRepository repo;

	private String ImgLocation = Constants.DEFAULT_DIR + "festival";
	private String ImgLocation_for_DB = "./fesitval/";

	@Override
	public List<FestivalVO> getAllFestival(){
		return repo.findAll();
	}

	@Override
	public FestivalVO getFindFestival(int festivalId){
		return repo.findByFestivalId(festivalId);
	}

	@Override
	public void updateFestival(FestivalVO vo, MultipartFile file) throws Exception{ 
		if (file != null) {
			String fileName = file.getOriginalFilename();

			File saveFile = new File(ImgLocation, fileName);

			file.transferTo(saveFile);

			vo.setFestivalImage(ImgLocation_for_DB + fileName);
		}

		repo.save(vo);
	}

	@Override
	public void deleteFestival(FestivalVO vo) {
		repo.delete(vo);
	}

	//글 작성 처리
	@Override
	public void insertFestival(FestivalVO vo, MultipartFile file) throws Exception{
		String fileName = file.getOriginalFilename();

		File saveFile = new File(ImgLocation, fileName);

		file.transferTo(saveFile);

		vo.setFestivalImage(ImgLocation_for_DB + fileName);

		repo.save(vo);
	}

	@Override
	public List<FestivalVO> boardSearchList(String searchKeyword) {

		return repo.findByfestivalNameContaining(searchKeyword);

	}


}
