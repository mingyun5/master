package org.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.board.model.BoardVO;
import org.study.board.model.Criteria;
import org.study.board.model.TodoVO;
import org.study.board.persistence.TodoDAO;

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
