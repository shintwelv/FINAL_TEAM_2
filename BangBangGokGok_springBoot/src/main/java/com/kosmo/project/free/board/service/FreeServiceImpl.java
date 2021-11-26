package com.kosmo.project.free.board.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.free.board.model.FreeVO;
import com.kosmo.project.free.board.repository.FreeRepository;
import com.kosmo.project.util.Constants;


@Service
public class FreeServiceImpl implements FreeService{
	@Autowired
	private FreeRepository repo;

	private String ImgLocation = Constants.DEFAULT_DIR + "free";
	private String ImgLocation_for_DB = "./free/";

	@Override
	public List<FreeVO> getFreeList(int freeId) {
		return repo.findAll();
	}

	@Override
	public FreeVO getFree(int freeId) {
		return repo.findByFreeId(freeId);
	}

	@Override
	public List<FreeVO> getAllFree() {
		return repo.findAll();
	}

	@Override
	public void insertFree(FreeVO vo, MultipartFile file) throws Exception{
		String fileName = file.getOriginalFilename();

		File saveFile = new File(ImgLocation, fileName);

		file.transferTo(saveFile);
		vo.setFreeImage(ImgLocation_for_DB + fileName);

		repo.save(vo);
	}

	@Override
	public void updateFree(FreeVO vo,MultipartFile file) throws Exception{
		if (file != null) {
			String fileName = file.getOriginalFilename();

			File saveFile = new File(ImgLocation, fileName);

			file.transferTo(saveFile);

			vo.setFreeImage(ImgLocation_for_DB + fileName);
		}

		repo.save(vo);
	}

	@Override
	public void deleteFree(FreeVO vo) {
		repo.delete(vo);
	}

	@Override
	public List<FreeVO> freeSearchList(String searchKeyword) {
		return repo.findByFreeTitle(searchKeyword);
	}

}
