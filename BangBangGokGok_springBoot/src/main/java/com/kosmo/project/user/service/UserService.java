package com.kosmo.project.user.service;

import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.user.model.UserVO;

public interface UserService {

	void deleteUser(UserVO vo);

	UserVO getUserByIdAndPw(String userId, String userPw);

	UserVO getUserById(String userId);

	UserVO createUser(UserVO vo, MultipartFile file);

	UserVO updateUser(UserVO vo, MultipartFile file);

}