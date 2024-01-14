package com.moveone.app.products;

import java.util.List;

import com.moveone.app.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products/*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {
		List<ProductDTO> productDTOList = productService.getList(pager);

		model.addAttribute("list", productDTOList);
		model.addAttribute("pager", pager);

		return "products/list";
	}

	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String getDetail(ProductDTO productDTO, Model model) throws Exception{
		productDTO = productService.getDetail(productDTO);

		model.addAttribute("dto",productDTO);

		return "products/detail";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(ProductDTO productDTO, MultipartFile[] files, Model model) throws Exception {
		int result = productService.add(productDTO, files);

		String msg = (result == 1) ? "등록 성공" : "동록 실패";

		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");

		return "commons/result";
	}

	@RequestMapping(value="add", method = RequestMethod.GET)
	public String add() {
		return "products/add";
	}


}
