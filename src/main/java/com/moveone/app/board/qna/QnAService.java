package com.moveone.app.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.board.BoardDAO;
import com.moveone.app.board.BoardDTO;
import com.moveone.app.board.BoardFileDTO;
import com.moveone.app.board.BoardService;
import com.moveone.app.utils.FileManager;
import com.moveone.app.utils.Pager;

@Service
public class QnAService implements BoardService{

	@Autowired
	@Qualifier("qnADAO")
	private BoardDAO boardDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount = boardDAO.getTotalCount(pager);
		pager.makeBlock(totalCount);
		return boardDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return boardDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		int result = boardDAO.setAdd(boardDTO);
		
		String path = servletContext.getRealPath("/resources/upload/qna");
		for(MultipartFile file : files) {
			if(file.isEmpty()) continue;
			
			String filename = fileManager.fileSave(file, path);
			BoardFileDTO fileDTO = new BoardFileDTO();
			fileDTO.setNoticeNum(boardDTO.getNoticeNum());
			fileDTO.setFileName(filename);
			fileDTO.setOriName(file.getOriginalFilename());
			
			boardDAO.setAddFile(fileDTO);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int setReply(QnADTO qnaDTO, MultipartFile[] files) throws Exception {
		QnADTO parentDTO = (QnADTO) boardDAO.getDetail(qnaDTO);
		/*update*/
		int result = ((QnADAO)boardDAO).setUpdateStep(parentDTO);
		System.out.println("updated : " + result);
		/*insert*/
		qnaDTO.setNoticeRef(parentDTO.getNoticeRef());
		qnaDTO.setNoticeStep(parentDTO.getNoticeStep() + 1);
		qnaDTO.setNoticeDepth(parentDTO.getNoticeDepth() + 1);
		result = ((QnADAO)boardDAO).setAddReply(qnaDTO);
		System.out.println("reply insert : " + (result == 1 ? true : false));
		
		String path = servletContext.getRealPath("/resources/upload/qna");
		for(MultipartFile file : files) {
			if(file.isEmpty()) continue;
			
			String filename = fileManager.fileSave(file, path);
			BoardFileDTO fileDTO = new BoardFileDTO();
			fileDTO.setNoticeNum(qnaDTO.getNoticeNum());
			fileDTO.setFileName(filename);
			fileDTO.setOriName(file.getOriginalFilename());
			
			boardDAO.setAddFile(fileDTO);
		}
		
		return result;
	}
	
}
