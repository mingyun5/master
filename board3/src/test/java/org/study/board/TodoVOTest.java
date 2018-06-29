package org.study.board;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.study.board.model.TodoVO;
import org.study.board.persistence.TodoDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class TodoVOTest {
	
	@Autowired
	TodoDAO dao;
	@Test
	public void addTodoTest() {
		TodoVO vo = new TodoVO();
		
		vo.setTitle("새로운 타이틀");
		vo.setContent("새로운 컨텐트");
		vo.setTarget_date(Date.valueOf("2018-03-18"));
		
		try {
			dao.regist(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deleteTodo() {
		TodoVO vo = new TodoVO();
		vo.setBno(27);
		int bno = vo.getBno();
		
		try {
			dao.tododelete(bno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
