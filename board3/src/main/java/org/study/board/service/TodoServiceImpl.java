package org.study.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.board.model.TodoVO;

@Repository
public class TodoServiceImpl implements TodoService {
	
	private static final String name = "org.study.board.mapper.todoMapper";
	@Autowired
	SqlSession session;
	
	
	@Override
	public void regist(TodoVO vo) throws Exception {
		session.insert(name + ".todocreate" ,vo);

	}

	@Override
	public boolean tododelete(int bno) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean todoupdate(TodoVO vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TodoVO> listAll() throws Exception {
		return session.selectList(name+".todoListAll");
	}

}
