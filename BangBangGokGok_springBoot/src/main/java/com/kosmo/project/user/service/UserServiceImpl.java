package com.kosmo.project.user.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.user.model.UserVO;
import com.kosmo.project.user.repository.UserRepository;
import com.kosmo.project.util.Constants;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;
	
	private String ImgLocation = Constants.DEFAULT_DIR;
	
	@Override
	public UserVO createUser(UserVO vo, MultipartFile file) {
		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();
				
				File fileToSave = new File(ImgLocation, fileName);
				
				file.transferTo(fileToSave);
				
				vo.setProfileImage(fileName);
			}
			return repo.save(vo);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public UserVO updateUser(UserVO vo, MultipartFile file) {
		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();
				
				File fileToSave = new File(ImgLocation, fileName);
				
				file.transferTo(fileToSave);
				
				vo.setProfileImage(fileName);
			}
			return repo.save(vo);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public void deleteUser(UserVO vo) {
		try {
			repo.delete(vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public UserVO getUserByIdAndPw(String userId, String userPw) {
		try {
			return repo.findByUserIdAndUserPw(userId, userPw);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public UserVO getUserById(String userId) {
		try {
			return repo.findByUserId(userId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
