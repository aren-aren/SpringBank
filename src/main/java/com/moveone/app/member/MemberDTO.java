package com.moveone.app.member;

public class MemberDTO {
	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String address;
	private AvatarDTO avatar;
	
	public AvatarDTO getAvatar() {
		return avatar;
	}
	public void setAvatar(AvatarDTO avatar) {
		this.avatar = avatar;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MemberDTO [userName=" + userName + ", password=" + password + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", avatar=" + avatar + "]";
	}
	
	
}
