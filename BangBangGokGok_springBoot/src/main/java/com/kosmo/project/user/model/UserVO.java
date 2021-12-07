package com.kosmo.project.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@ToString
public class UserVO {
	@Id
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "ADMIN")
	private String admin;
	@Column(name = "USER_PW")
	private String userPw;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "NICKNAME")
	private String nickName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "USER_BASIC_ADDRESS")
	private String userBasicAddress;
	@Column(name = "USER_DETAIL_ADDRESS")
	private String userDetailAddress;
	@Column(name = "PROFILE_IMAGE")
	private String profileImage;
	@Column(name = "BIRTH")
	private Date birth;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "ENABLED")
	private Boolean enabled;
	

}
