package org.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.spring.project.model.BoardVO;
import org.spring.project.model.Criteria;
import org.spring.project.model.TodoVO;
import org.spring.project.persistence.TodoDAO;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoDAO dao;
	
	
	@Override
	public void regist(TodoVO vo) throws Exception {
		dao.regist(vo);
	}

	@Override
	public void tododelete(int bno) throws Exception {
		dao.tododelete(bno);
	}

	@Override
	public void todoupdate(TodoVO vo) throws Exception {
		dao.todoupdate(vo);
	}

	@Override
	public List<TodoVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public TodoVO todoread(int bno) throws Exception {
		return dao.todoread(bno);
	}
	@Override
	public List<TodoVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	@Override
	public int countTodoPage() throws Exception {
		return dao.getTotalTodoNum();
	}
}
