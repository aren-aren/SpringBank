package com.moveone.app.products;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.moveone.app.products.ReplyDAO.";
	
	public int setReply(ReplyDTO replyDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "setReply", replyDTO);
	}

	public List<ReplyDTO> getList(Map<String, Object> map) {
		return sqlSession.selectList(NAMESPACE + "getList", map);
	}
	
	public int setUpdate(ReplyDTO replyDTO) throws Exception{
		return sqlSession.update(NAMESPACE + "setUpdate", replyDTO);
	}
}
