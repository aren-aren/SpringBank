package com.moveone.app.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moveone.app.utils.Pager;

@Service
public class ReplyService {
	@Autowired
	private ReplyDAO replyDAO;
	
	public int setReply(ReplyDTO replyDTO) throws Exception {
		return replyDAO.setReply(replyDTO);
	}

	public List<ReplyDTO> getList(ProductDTO productDTO, Pager pager) {
		pager.setPerPage(5L);
		pager.makeRow();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dto", productDTO);
		map.put("pager", pager);
		
		return replyDAO.getList(map);
	}
}
