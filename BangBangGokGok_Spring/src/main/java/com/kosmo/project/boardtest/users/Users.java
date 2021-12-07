package com.kosmo.project.boardtest.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "users")
public class Users {
	@Id
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "USER_PW")
	private String userPw;
	@Column(name = "ENABLED")
	private boolean enabled;
	@Column(name = "NICKNAME")
	private String nickName;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "ADMIN")
	private String admin;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	
	public Users(String userId, String userPw, boolean enabled) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.enabled = enabled;
		this.nickName = "관리자";
		this.userName = "관리자";
		this.admin = "Y";
	}
	

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPw=" + userPw + ", enabled=" + enabled + "]";
	}

	
}
