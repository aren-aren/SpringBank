package com.moveone.app.member;

import java.util.List;

import com.moveone.app.member.role.RoleDTO;

public class MemberDTO {
	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String address;
	private AvatarDTO avatar;
	private List<RoleDTO> roles;
	
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
	
	public List<RoleDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "MemberDTO [userName=" + userName + ", password=" + password + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", avatar=" + avatar + ", roles=" + roles + "]";
	}
	
	
}
