package com.kosmo.project.user.service;

import java.util.List;

import com.kosmo.project.user.model.UserVO;

public interface UserService {

	UserVO getUser(UserVO vo);

	void deletUser(UserVO vo);

	void updateUser(UserVO vo);

	void insertUser(UserVO vo);

	List<UserVO> getAllUsers();

	UserVO chkUser(UserVO vo);
	
	UserVO createUser(UserVO vo);

}