package com.moveone.app.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moveone.app.board.BoardDAO;
import com.moveone.app.board.BoardDTO;
import com.moveone.app.board.BoardFileDTO;
import com.moveone.app.utils.Pager;

@Repository
public class NoticeDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.moveone.app.board.notice.NoticeDAO.";
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(namespace+"getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(namespace + "getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(namespace + "setAdd", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(namespace + "setDelete", boardDTO);
	}

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "getTotalCount", pager);
	}

	@Override
	public int setAddFile(BoardFileDTO fileDTO) throws Exception {
		return sqlSession.insert(namespace + "setAddFile", fileDTO);
	}

	@Override
	public List<BoardFileDTO> getFileList(BoardDTO boardDTO) {
		return sqlSession.selectList(namespace + "getFileList", boardDTO);
	}

	@Override
	public int setDeleteFiles(BoardDTO boardDTO) {
		return sqlSession.delete(namespace + "setDeleteFiles", boardDTO);
	}
	
	

}
