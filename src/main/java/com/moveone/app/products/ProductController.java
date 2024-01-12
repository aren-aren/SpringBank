package com.moveone.app.products;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/products/*")
public class ProductController {
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList() throws Exception {
		return "products/list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() throws Exception {
		return "products/add";
	}
}
