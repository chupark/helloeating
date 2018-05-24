package com.helloeating.login.domain;

public class MemberVO {

	private int num;
	private String member_id;
	private String member_nickname;
	private String member_password;
	private String device_token;
	private String os_type;
	private float app_version;
	private String login_token;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	} 	
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getDevice_token() {
		return device_token;
	}
	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}
	public String getOs_type() {
		return os_type;
	}
	public void setOs_type(String os_type) {
		this.os_type = os_type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getApp_version() {
		return app_version;
	}
	public void setApp_version(float app_version) {
		this.app_version = app_version;
	}
	public String getLogin_token() {
		return login_token;
	}
	public void setLogin_token(String login_token) {
		this.login_token = login_token;
	}
	
	
}
