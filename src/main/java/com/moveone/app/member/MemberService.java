package com.moveone.app.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.errors.MemberLoginException;
import com.moveone.app.member.role.RoleDTO;
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
		
		RoleDTO role = new RoleDTO();
		role.setRoleName("ROLE_MEMBER");
		
		List<RoleDTO> roles = new ArrayList<RoleDTO>();
		roles.add(role);
		
		memberDTO.setRoles(roles);
		memberDAO.setMemberRole(memberDTO);
		
		String fileName = fileManager.fileSave(avatar, servletContext.getRealPath("/resources/upload/avatar"));
		
		AvatarDTO avatarDTO = new AvatarDTO();
		avatarDTO.setUserName(memberDTO.getUserName());
		avatarDTO.setFileName(fileName);
		avatarDTO.setOriName(avatar.getOriginalFilename());
		
		result += memberDAO.addAvatar(avatarDTO);
		
		return result;
	}

	public MemberDTO getLogin(MemberDTO loginDTO) throws MemberLoginException {
		MemberDTO memberDTO = memberDAO.getDetail(loginDTO);
		
		if( memberDTO!=null && memberDTO.getPassword().equals(loginDTO.getPassword()) ) {
			loginDTO.setAvatar(memberDTO.getAvatar());
			loginDTO.setRoles(memberDTO.getRoles());
			return loginDTO;
		}
			
		throw new MemberLoginException("아이디 또는 비밀번호가 틀립니다.");
	}

	public int setUpdate(MemberDTO memberDTO) {
		return memberDAO.setUpdate(memberDTO);
	}
	
	public MemberDTO getDetail(MemberDTO memberDTO) {
		return memberDAO.getDetail(memberDTO);
	}

}
