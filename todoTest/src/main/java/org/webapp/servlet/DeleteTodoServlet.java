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
 * Servlet implementation class DeleteTodoServlet
 */
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TodoService service = new TodoDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		if(service.tododelete(idx)) {
			response.sendRedirect("/listTodoServlet?page="+page);
		}else {
			request.setAttribute("error", "삭제 실패");
			String Id = (String) request.getSession().getAttribute("user_id");
			List<Todo> list = service.listAll(page, Id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/listTodo.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
