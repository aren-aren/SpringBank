package com.moveone.app.interceptors;

import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.moveone.app.member.MemberDTO;
import com.moveone.app.member.role.RoleDTO;

@Component
public class AdminCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		List<RoleDTO> roles = memberDTO.getRoles();
		
		Optional<RoleDTO> admin = roles.stream().filter(role-> role.getRoleName().equals("ROLE_ADMIN")).findAny();
		
		if(admin.isEmpty()) {
			request.setAttribute("msg", "권한이 필요합니다.");
			request.setAttribute("path", "/");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			view.forward(request, response);
			return false;
		}
		
		return true;
	}

	
}
