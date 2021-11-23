package com.kosmo.project.festival.board.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kosmo.project.festival.board.model.FestivalVO;

@Repository
public interface FestivalRepository extends CrudRepository<FestivalVO, Integer> {
	List<FestivalVO> findAll();
	
	FestivalVO findByFestivalId(int festivalId);
	
	FestivalVO save(FestivalVO vo);
	
	void delete(FestivalVO vo);	
	
	List<FestivalVO> findByfestivalNameContaining(String searchKeyword);
	
}
