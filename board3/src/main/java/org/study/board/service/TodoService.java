package org.study.board.service;

import java.util.List;

import org.study.board.model.TodoVO;

public interface TodoService {
	
	public void regist(TodoVO vo) throws Exception;
	
	public boolean tododelete(int bno) throws Exception;
	
	public boolean todoupdate(TodoVO vo) throws Exception;
	
	public List<TodoVO> listAll() throws Exception;
	
}
