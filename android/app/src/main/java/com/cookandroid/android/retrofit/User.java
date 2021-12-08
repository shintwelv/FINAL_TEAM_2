package com.cookandroid.android.retrofit;

import java.util.Date;

public class User {
    private String userId;
    private String userPw;
    private String userName;
    private String nickName;
    private String email;
    private String phoneNumber;
    private String userBasicAddress;
    private String userDetailAddress;
    private String profileImage;
//    private Date birth;
    private String gender;
    private String admin;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserBasicAddress() {
        return userBasicAddress;
    }

    public void setUserBasicAddress(String userBasicAddress) {
        this.userBasicAddress = userBasicAddress;
    }

    public String getUserDetailAddress() {
        return userDetailAddress;
    }

    public void setUserDetailAddress(String userDetailAddress) {
        this.userDetailAddress = userDetailAddress;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
