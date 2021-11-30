package com.kosmo.project.user.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.user.model.UserVO;
import com.kosmo.project.user.service.UserService;
import com.kosmo.project.util.Constants;
import com.oreilly.servlet.MultipartRequest;

@RestController
//@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
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
	
	
//	@requestbody 필요
	
	
	@RequestMapping(value = "/insertProcess.do")
	public boolean insertProcess(UserVO vo, HttpServletRequest request) {
		try {
			UserVO voToInsert = setUserByMultiRequest(vo, request);
			System.out.println(voToInsert);
			service.insertUser(voToInsert);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = "/updateProcess.do")
	public boolean updateProcess(UserVO vo, HttpServletRequest request) {
		try {
			UserVO voToUpdate = setUserByMultiRequest(vo, request);
			service.updateUser(voToUpdate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping(value = "/deleteProcess.do")
	public boolean deleteProcess(UserVO vo, HttpServletRequest request) {
		try {
			UserVO voToDelete = setUserByMultiRequest(vo, request);
			service.deletUser(voToDelete);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	private UserVO setUserByMultiRequest(UserVO vo, HttpServletRequest request) {
		MultipartRequest multiRequest;
		
		try {
			multiRequest = new MultipartRequest(request, PROFILE_IMAGE_FOLDER, 1024*1024*100, "utf-8");
			vo.setUser_id(multiRequest.getParameter("user_id"));
			vo.setUser_pw(multiRequest.getParameter("user_pw"));
			vo.setUser_name(multiRequest.getParameter("user_name"));
			vo.setNickname(multiRequest.getParameter("nickname"));
			vo.setEmail(multiRequest.getParameter("email"));
			vo.setPhone_number(multiRequest.getParameter("phone_number"));
			vo.setProfile_image("./resources/images/"+ multiRequest.getOriginalFileName("profile_image"));
			vo.setUser_basic_address(multiRequest.getParameter("user_basic_address"));
			vo.setUser_detail_address(multiRequest.getParameter("user_detail_address"));
//			날짜 파싱 오류, nullPointerException 처리용
			try {
				vo.setBirth(new SimpleDateFormat("yyyy-mm-dd").parse(multiRequest.getParameter("birth")));
			} catch (Exception e) {
				vo.setBirth(null);
			}
			vo.setGender(multiRequest.getParameter("gender"));
			vo.setAdmin("N");
			
			return vo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value = "/getUser")
	public UserVO getUser(UserVO vo) {
		vo = service.getUser(vo);
		return vo;
	}
	
	@RequestMapping(value = "/chkUser")
	public boolean chkUser(@RequestBody UserVO vo) {
		UserVO user = service.chkUser(vo);
		if (user == null) {
			return false;
		}
		return true;
	}
}
