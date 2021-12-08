package com.kosmo.project.user.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.user.model.UserVO;
import com.kosmo.project.user.service.UserService;
import com.kosmo.project.util.Constants;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService service;
	@Autowired
	private PasswordEncoder pwEncoder;
	
//	이 위치에 회원의 프로필 사진이 저장됨
	private static final String PROFILE_IMAGE_FOLDER = Constants.DEFAULT_DIR;
	
//	프로필 사진 저장 폴더가 없을 시 생성
	public UserController() {
		Path path = Paths.get(PROFILE_IMAGE_FOLDER);
		System.out.println("directory Location: " + PROFILE_IMAGE_FOLDER);
		try {
			Files.createDirectories(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/insert")
	public UserVO createUser(UserVO vo, @RequestParam("Image") MultipartFile file) {
		try {
			vo.setUserPw(pwEncoder.encode(vo.getUserPw()));
			return service.createUser(vo, file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/update")
	public UserVO updateUser(UserVO vo, @RequestParam("Image") MultipartFile file) {
		try {
			vo.setUserPw(pwEncoder.encode(vo.getUserPw()));
			return service.updateUser(vo, file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/delete")
	public boolean deleteUser(@RequestParam("userId") String userId) {
		try {
			UserVO vo = new UserVO();
			vo.setUserId(userId);
			service.deleteUser(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = "/login")
	public UserVO userExists(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw) {
		try {
			UserVO user = service.getUserById(userId);
			if (pwEncoder.matches(userPw, user.getUserPw())) {
				return user;
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/membership")
	public boolean signUpAndroid(@RequestBody UserVO vo) {
		System.out.println(vo);
		try {
			service.createUser(vo, null);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = "/chkUserAndroid")
	public boolean chkUserAndroid(@RequestBody UserVO vo) {
		try {
			UserVO user = service.getUserById(vo.getUserId());
			if (pwEncoder.matches(vo.getUserPw(), user.getUserPw())) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
}
