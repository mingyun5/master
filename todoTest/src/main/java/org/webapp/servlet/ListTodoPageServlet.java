package org.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.webapp.dao.Todo;
import org.webapp.dao.TodoDAOImpl;
import org.webapp.dao.TodoService;

/**
 * Servlet implementation class ListTodoPageServlet
 */
public class ListTodoPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoService service = new TodoDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		
		String id = (String) request.getSession().getAttribute("user_id");
		List<Todo> list = service.listAll(page, id);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/listTodo.jsp").forward(request, response);
	}

}
