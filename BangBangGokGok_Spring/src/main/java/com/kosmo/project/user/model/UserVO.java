package com.kosmo.project.user.model;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class UserVO {
	
	private String user_id;
	private String user_pw;
	private String user_name;
	private String nickname;
	private String email;
	private String phone_number;
	private String user_basic_address;
	private String user_detail_address;
	private String profile_image;
	private Date birth;
	private String gender;
	private String admin;

}