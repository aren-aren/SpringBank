package com.moveone.app.member;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.utils.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	public int join(MemberDTO memberDTO, MultipartFile avatar) throws Exception {
		int result = memberDAO.join(memberDTO);
		
		String fileName = fileManager.fileSave(avatar, servletContext.getRealPath("/resources/upload/avatar"));
		
		AvatarDTO avatarDTO = new AvatarDTO();
		avatarDTO.setUserName(memberDTO.getUserName());
		avatarDTO.setFileName(fileName);
		avatarDTO.setOriName(avatar.getOriginalFilename());
		
		result += memberDAO.addAvatar(avatarDTO);
		
		return result;
	}

	public MemberDTO getLogin(MemberDTO loginDTO) {
		MemberDTO memberDTO = memberDAO.getDetail(loginDTO);
		
		if(memberDTO != null) {
			if(memberDTO.getPassword().equals(loginDTO.getPassword())) {
				return memberDTO;
			}
			
			return null;
		}
		
		return memberDTO;
	}

}
