package org.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDAOImpl implements TodoService {
	private static final String URL = "jdbc:mysql://192.168.0.203/test_db?useSSL=no&characterEncoding=utf8";
	private static final String USER = "mingyun";
	private static final String PW = "alsrbs3193!";

	Connection conn; // sql 접속할 수 있게 설정하는 객체
	PreparedStatement ps; // sql 쿼리를 실행시켜주는 객체
	ResultSet rs; // sql select 쿼리 결과를 리턴받아 저장하는 객체

	// sql 접소 메소드
	public void getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PW);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addTodo(Todo todo) {
		int status = 0;
		getConn();

		try {
			String sql = "insert into todo01 (user_id,content,target_date,category) values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, todo.getId());
			ps.setString(2, todo.getContent());
			ps.setDate(3, todo.getTargetDate());
			ps.setInt(4, todo.getCategory());
			status = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status != 0 ? true:false;
	}

	@Override
	public List<Todo> listAll(int page, String id) {
		List<Todo> list = new ArrayList<>();
		
		getConn();
		
		String sql = "select a.idx, a.content, a.target_date, a.create_date, a.done, b.name, a.category\r\n"
					+ "from todo a inner join todo_category b\r\n" + "on a.category = b.cat_id\r\n"
					+ "where a.user_id = ?\r\n" + "limit ?,?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, (page - 1) * TodoService.page);
			ps.setInt(3, TodoService.page);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setIdx(rs.getInt(1));
				todo.setContent(rs.getString(2));
				todo.setTargetDate(rs.getDate(3));
				todo.setCreateDate(rs.getDate(4));
				todo.setDone(rs.getBoolean(5));
				todo.setCtgName(rs.getString(6));
				todo.setCategory(rs.getInt(7));
				list.add(todo);
				
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Todo> todoList(int cate, int page, String id) {
		List<Todo>list = new ArrayList<>();
		getConn();
		
		String sql = "select a.idx, a.content, a.target_date, a.create_date, a.done, b.name, a.category \r\n"
				+ "from todo a inner join todo_category b\r\n" + "	on a.category = b.cat_id\r\n"
				+ "and a.category = " + cate + "\r\n" + "and a.user_id =" + "\'" + id + "\'" + "\n" + "limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * TodoService.page);
			ps.setInt(2, TodoService.page);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				Todo todo = new Todo();
				todo.setIdx(rs.getInt(1));
				todo.setContent(rs.getString(2));
				todo.setTargetDate(rs.getDate(3));
				todo.setCreateDate(rs.getDate(4));
				todo.setDone(rs.getBoolean(5));
				todo.setCtgName(rs.getString(6));
				todo.setCategory(rs.getInt(7));
				list.add(todo);
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Todo getTodo(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean tododelete(int idx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCtgName(int category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int maxpage(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int maxpage(String id, int category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Todo> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
