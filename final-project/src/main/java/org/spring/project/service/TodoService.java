package org.spring.project.service;

import java.util.List;

import org.spring.project.model.BoardVO;
import org.spring.project.model.Criteria;
import org.spring.project.model.TodoVO;

public interface TodoService {

	public void regist(TodoVO vo) throws Exception;
	
	public void tododelete(int bno) throws Exception;
	
	public void todoupdate(TodoVO vo) throws Exception;
	
	public List<TodoVO> listAll() throws Exception;
	
	public TodoVO todoread(int bno) throws Exception;
	
	public List<TodoVO> listCriteria(Criteria cri) throws Exception;
	
	public int countTodoPage() throws Exception;
	
}
