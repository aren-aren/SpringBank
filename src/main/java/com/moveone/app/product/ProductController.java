package com.moveone.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moveone.app.util.Pager;

/*
 * controller에서 parameter처리
 * 1. Bean (객체, DTO)
 * 2. parameter와 같은 이름과 타입으로 선언
 * 3. request -> 거의 사용하지 않음
 * 
 * Controller에서 JSP로 Data전달
 * 1. Model(ModelAndView) -> Spring이 관리
 * 2. request -> Tomcat이 관리
 * 
 * JSP경로
 * return이 void : URL경로명이 설정
 * 		  String : URL경로 리턴
 * 	ModelAndView : View객체에 setViewName으로 설정
 */

@Controller
@RequestMapping(value="/products/*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Pager pager, Model model) throws Exception {
		List<ProductDTO> list = productService.getList(pager);
		model.addAttribute("list", list);
		
		return "products/list";
	}

	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(Long productNum, Model model) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(productNum);
		
		productDTO = productService.getDetail(productDTO);
		
		model.addAttribute("dto", productDTO);
		
		return "products/detail";
	}
}
