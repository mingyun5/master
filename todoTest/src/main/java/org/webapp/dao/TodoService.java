package org.webapp.dao;

import java.util.List;

public interface TodoService {
	int page = 10;
	
	public boolean addTodo(Todo todo);
	
	public List<Todo> listAll(int page, String id);
	
	public boolean tododelete(int idx);
	
	public Todo getTodo(int idx);
	
	public boolean todoupdate(Todo todo);
	
	public int maxpage(String id);
	
	public String ctgName(int category);
}
