package com.moveone.app.board;

import java.util.List;

public interface BoardDAO {

	public List<BoardDTO> getList() throws Exception;
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	public int setAdd(BoardDTO boardDTO) throws Exception;
	
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	public Long getTotalCount() throws Exception;
}
