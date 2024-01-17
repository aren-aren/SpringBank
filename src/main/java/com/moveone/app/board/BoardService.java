package com.moveone.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.utils.Pager;

public interface BoardService {

	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception;
	
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception;
	
	public int setDelete(BoardDTO boardDTO) throws Exception;
}
