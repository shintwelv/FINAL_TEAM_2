package com.kosmo.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosmo.project.user.model.UserVO;
@Repository
public interface UserRepository extends JpaRepository<UserVO, String>{
	
	UserVO findByUserId(String userId);
	
	UserVO findByUserIdAndUserPw(String userId, String userPw);

}
