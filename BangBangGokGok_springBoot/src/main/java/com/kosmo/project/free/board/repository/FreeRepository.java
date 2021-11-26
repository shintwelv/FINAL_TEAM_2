package com.kosmo.project.free.board.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kosmo.project.free.board.model.FreeVO;

@Repository
public interface FreeRepository extends CrudRepository<FreeVO, Integer>{
	
		List<FreeVO> findAll();
		
		FreeVO findByFreeIdAndFreeTitle(int freeId, String freeTtitle);

		FreeVO findByFreeId(int FreeId);
		
		List<FreeVO> findByFreeTitle(String freeTitle);
		
		
		List<FreeVO> findByFreeIdAndFreeTitleAndFreeWriterId
		(int freeId, String freeTitle, String freeWriterId);
		
		FreeVO save(FreeVO vo);
		
		void delete(FreeVO vo);

}
