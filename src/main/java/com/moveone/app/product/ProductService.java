package com.moveone.app.product;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.util.FileManager;
import com.moveone.app.util.Pager;

@Service
public class ProductService {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	ServletContext servletContext;
	@Autowired
	FileManager fileManager;
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		pager.makeRows();
		Long totalCount = productDAO.getTotal(pager);
		pager.makeNum(totalCount);
		
		
		return productDAO.getList(pager);
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception {
		return productDAO.getDetail(dto);
	}

	public int add(ProductDTO productDTO, MultipartFile[] files) throws Exception {
		int result = productDAO.addProduct(productDTO);
		
		String path = servletContext.getRealPath("/resources/upload/products");
		
		for(MultipartFile f : files) {
			if(f.isEmpty()) {
				continue;
			}
			
			String filename = fileManager.fileSave(path, f);
		
			ProductFileDTO fileDTO = new ProductFileDTO();
			fileDTO.setFileName(filename);
			fileDTO.setOriName(f.getOriginalFilename());
			fileDTO.setProductNum(productDTO.getProductNum());
		
			productDAO.addFile(fileDTO);
		}
		
		return result;
	}
}
