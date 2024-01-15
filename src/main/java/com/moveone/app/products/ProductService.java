package com.moveone.app.products;

import com.moveone.app.utils.FileManager;
import com.moveone.app.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    ServletContext servletContext;
    @Autowired
    FileManager fileManager;

    public List<ProductDTO> getList(Pager pager) {
        pager.makeRow();
        Long totalRow = productDAO.getTotal(pager);

        pager.makeBlock(totalRow);

        return productDAO.getList(pager);
    }

    public int add(ProductDTO productDTO, MultipartFile[] files) throws Exception {
        int result = productDAO.add(productDTO);

        String path = servletContext.getRealPath("/resources/upload/products");

        for (MultipartFile file : files) {
            if(file.isEmpty()){
                continue;
            }

            String fileName = fileManager.fileSave(file, path);

            ProductFileDTO fileDTO = new ProductFileDTO();
            fileDTO.setProductNum(productDTO.getProductNum());
            fileDTO.setFileName(fileName);
            fileDTO.setOriName(file.getOriginalFilename());

            productDAO.addFile(fileDTO);
        }

        return result;
    }

    public ProductDTO getDetail(ProductDTO productDTO) {
        ProductDTO detail = productDAO.getDetail(productDTO);

        return detail;
    }
}
