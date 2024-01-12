package com.moveone.app.products;

import java.util.List;
import java.util.Map;

import com.moveone.app.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/products/*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {

		List<ProductDTO> productDTOList = productService.getList(pager);

		model.addAttribute("list", productDTOList);

		return "products/list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() throws Exception {
		return "products/add";
	}
}
