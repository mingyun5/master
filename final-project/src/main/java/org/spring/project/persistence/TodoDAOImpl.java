package org.spring.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.spring.project.model.BoardVO;
import org.spring.project.model.Criteria;
import org.spring.project.model.TodoVO;

@Repository
public class TodoDAOImpl implements TodoDAO {
	
	private static final String name = "org.study.board.mapper.todoMapper";
	@Autowired
	SqlSession session;
	
	
	@Override
	public void regist(TodoVO vo) throws Exception {
		session.insert(name + ".todocreate" ,vo);

	}

	@Override
	public void tododelete(Integer bno) throws Exception {
		session.delete(name + ".tododelete", bno);
	}

	@Override
	public void todoupdate(TodoVO vo) throws Exception {
		session.update(name + ".todoupdate", vo);
	}

	@Override
	public List<TodoVO> listAll() throws Exception {
		List<TodoVO> todos = session.selectList(name+".todoListAll");
		for (TodoVO vo : todos) {
			System.out.println(vo);
		}
		
		return session.selectList(name+".todoListAll");
	}

	@Override
	public TodoVO todoread(Integer bno) throws Exception {
		
		return session.selectOne(name+".todoread", bno);
	}
	
	@Override
	public List<TodoVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		
		return session.selectList(name + ".listPage", page);
	}

	@Override
	public List<TodoVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(name + ".listCriteria", cri);
	}
	
	@Override
	public int getTotalTodoNum() throws Exception {
		return session.selectOne(name + ".getTotal");
	}

}
