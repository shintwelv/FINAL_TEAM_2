package com.kosmo.project.boardtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosmo.project.boardtest.manager.Manager;
import com.kosmo.project.boardtest.manager.ManagerRepository;
import com.kosmo.project.boardtest.users.Users;
import com.kosmo.project.boardtest.users.UsersRepository;

@Controller
public class CommController {
	
	@Autowired private UsersRepository ur;
	@Autowired private ManagerRepository mr;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="userJoin.do", method=RequestMethod.POST)
	public String userJoin(Users user, Manager manager) {
		System.out.println("## [loginPOST]");
		System.out.println(ur.save(new Users(user.getUserId(), passwordEncoder.encode(user.getUserPw()), user.isEnabled())));
		System.out.println(mr.save(new Manager(user.getUserId(), manager.getAdminLevel())));
		return "redirect:/index.jsp";
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String loginGet() {
//		System.out.println("## [loginGET]");
//		return "login";
//	}
	
	@RequestMapping(value="/loginFaile", method=RequestMethod.GET)
	public String loginFaile(Model model) {
		model.addAttribute("loginFaile", "true");
		return "login";
	}
}
