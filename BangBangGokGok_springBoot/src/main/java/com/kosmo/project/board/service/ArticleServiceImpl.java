package com.kosmo.project.board.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.board.model.ArticleVO;
import com.kosmo.project.board.repository.ArticleRepository;
import com.kosmo.project.util.Constants;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository repo;
	
	private String ImgLocation = Constants.DEFAULT_DIR;
	private String ImgLocation_for_DB = "./";
	
	@Override
	public List<ArticleVO> getArticleByArticleCode(String articleCode) {
		try {
			return repo.findByArticleCodeOrderByWriteDateDesc(articleCode);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public ArticleVO getArticleByArticleNo(int articleNo) {
		try {
			return repo.findByArticleNo(articleNo);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public boolean updateArticle(ArticleVO vo, MultipartFile file) {
		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();

				File saveFile = new File(ImgLocation, fileName);

				file.transferTo(saveFile);

				vo.setArticleImage(ImgLocation_for_DB + fileName);
			}
			repo.save(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@Override
	public boolean deleteArticle(ArticleVO vo) {
		try {
			repo.deleteById(vo.getArticleNo());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@Override
	public boolean createArticle(ArticleVO vo, MultipartFile file) {
		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();

				File saveFile = new File(ImgLocation, fileName);

				file.transferTo(saveFile);

				vo.setArticleImage(ImgLocation_for_DB + fileName);
			}
			repo.save(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	@Override
	public Page<ArticleVO> getArticleByArticleCodeOfPage(String articleCode, Pageable pageable){
		try {
			return repo.findByArticleCodeOrderByWriteDateDesc(articleCode, pageable);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
