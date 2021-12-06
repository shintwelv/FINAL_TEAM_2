package com.kosmo.project.boardtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.project.boardtest.users.Users;
import com.kosmo.project.boardtest.users.UsersRepository;

@Service("managerService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository ur;
	
	@Override
	public Users findOne(String username) {
		return ur.findOne(username);
	}

}
