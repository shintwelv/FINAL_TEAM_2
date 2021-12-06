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
	@Column(name = "user_id")
	private String username;
	@Column(name = "user_pw")
	private String password;
	@Column(name = "enabled")
	private boolean enabled;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
	
}
