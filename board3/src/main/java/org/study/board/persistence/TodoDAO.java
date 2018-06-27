package org.study.board.persistence;

import java.util.List;

import org.study.board.model.BoardVO;
import org.study.board.model.Criteria;
import org.study.board.model.TodoVO;

public interface TodoDAO {
	
	public void regist(TodoVO vo) throws Exception;
	
	public void tododelete(Integer bno) throws Exception;
	
	public void todoupdate(TodoVO vo) throws Exception;
	
	public List<TodoVO> listAll() throws Exception;
	
	public TodoVO todoread(Integer bno) throws Exception;
	
	public List<TodoVO> listPage(int page) throws Exception;
	
	public List<TodoVO> listCriteria(Criteria cri) throws Exception;
	
	public int  getTotalTodoNum() throws Exception;
	
}
