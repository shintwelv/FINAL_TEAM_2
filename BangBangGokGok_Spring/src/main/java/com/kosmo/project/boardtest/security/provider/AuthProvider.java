package com.kosmo.project.boardtest.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kosmo.project.boardtest.manager.Manager;
import com.kosmo.project.boardtest.manager.ManagerRepository;
import com.kosmo.project.boardtest.users.Users;
import com.kosmo.project.boardtest.users.UsersRepository;

public class AuthProvider implements AuthenticationProvider{

	@Autowired
	private UsersRepository ur;
	
	@Autowired
	private ManagerRepository mr;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
		System.out.println("authToken.getName() : "+authToken.getName());
		System.out.println("authToken.getAuthorities() : "+authToken.getAuthorities());
		System.out.println("authToken.getClass() : "+authToken.getClass());
		System.out.println("authToken.getCredentials() : "+authToken.getCredentials());
		System.out.println("authToken.getDetails() : "+authToken.getDetails());
		System.out.println("authToken.getPrincipal() : "+authToken.getPrincipal());
		
		Users user = ur.findOne(authToken.getName()); 
		
		if(user == null) throw new UsernameNotFoundException(authToken.getName());
		
		if(!user.getPassword().equals(authToken.getCredentials())) throw new BadCredentialsException(user.getUsername());
		
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		
		for(Manager auth : mr.findByAdminId(user.getUsername())) {
			authList.add(new SimpleGrantedAuthority(auth.getAdminLevel()));
		}
		
		return new UsernamePasswordAuthenticationToken(new Users(user.getUsername(), null, true), null, authList);
		// users 테이블의 enabeld 컬럼을 String으로 변경 후 error 발생 , provider로 사용할 경우 이부분 확인해봐야한다.
//		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
