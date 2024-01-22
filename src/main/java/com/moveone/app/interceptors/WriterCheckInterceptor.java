package com.moveone.app.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.moveone.app.board.BoardDTO;
import com.moveone.app.member.MemberDTO;

@Component
public class WriterCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		String method = request.getMethod();
		if(method.toUpperCase().equals("POST")) {
			return;
		}
		
		Map<String, Object> map = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)map.get("dto"); //작성자 정보
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		if(!boardDTO.getWriter().equals(memberDTO.getUserName())) {
			modelAndView.addObject("msg", "작성자만 수정이 가능합니다.");
			modelAndView.addObject("path", "./list");
			modelAndView.setViewName("commons/result");
		}
		
//		Iterator<String> iter = map.keySet().iterator();
//		
//		while(iter.hasNext()) {
//			String key = iter.next();
//			System.out.println(key + " : " + map.get(key));
//		}

		System.out.println(modelAndView.getViewName());
	}
	
}
