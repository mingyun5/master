package org.webapp.dao;

import java.util.List;

public interface TodoService {
	int page = 10;
	
	public boolean addTodo(Todo todo);
	
	public List<Todo> listAll(int page, String id);
	
	public List<Todo> todoList(int cate, int page, String id);
	
	public Todo getTodo(int idx);
	
	public boolean tododelete(int idx);
	
	public String getCtgName(int category);
	
	public int maxpage(String id);
	
	public int maxpage(String id, int category);
	
	public List<Todo> getCategory();
}
