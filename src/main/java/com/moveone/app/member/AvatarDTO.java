package com.moveone.app.member;

import com.moveone.app.files.FileDTO;

public class AvatarDTO extends FileDTO {
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "AvatarDTO [userName=" + userName + ", getOriName()=" + getOriName() + "]";
	}

	
}
