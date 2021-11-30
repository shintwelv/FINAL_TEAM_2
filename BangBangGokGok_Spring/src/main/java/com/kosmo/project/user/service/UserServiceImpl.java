package com.kosmo.project.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.project.user.model.UserVO;
import com.kosmo.project.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return repo.select(vo);
	}
	
	@Override
	public List<UserVO> getAllUsers() {
		return repo.selectAll();
	}
	
	@Override
	public void deletUser(UserVO vo) {
		repo.delete(vo);
	}
	
	@Override
	public void updateUser(UserVO vo) {
		repo.update(vo);
	}
	
	@Override
	public void insertUser(UserVO vo) {
		repo.insert(vo);
	}
	
	@Override
	public UserVO chkUser(UserVO vo) {
		return repo.chkUser(vo);
		
	}
	@Override
	public UserVO createUser(UserVO vo) {
		return repo.createUser(vo);
	}

}
