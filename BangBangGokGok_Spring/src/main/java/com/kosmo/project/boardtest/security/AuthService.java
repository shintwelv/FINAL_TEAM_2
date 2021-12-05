package com.kosmo.project.boardtest.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kosmo.project.boardtest.manager.Manager;
import com.kosmo.project.boardtest.manager.ManagerRepository;
import com.kosmo.project.boardtest.users.Users;
import com.kosmo.project.boardtest.users.UsersRepository;

public class AuthService implements UserDetailsService {

	@Autowired
	private UsersRepository ur;
	
	@Autowired
	private ManagerRepository mr;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("########### [UserDetailsService.loadUserByUsername]");
		Users user = ur.findByUsername(username);
		
		if(user == null) throw new UsernameNotFoundException(username);
		
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		for(Manager auth : mr.findByAdminId(username)) {
			System.out.println("auth : "+auth.getAdminLevel());
			authList.add(new SimpleGrantedAuthority(auth.getAdminLevel()));
		}
		
		return new User(username, user.getPassword(), authList);
	}
}
