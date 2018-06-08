package org.webapp.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.webapp.dao.Todo;
import org.webapp.dao.TodoDAOImpl;
import org.webapp.dao.TodoService;


@WebServlet("/UpdateTodoServlet")
public class UpdateTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TodoService service = new TodoDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		Todo todo = service.getTodo(idx);
		request.setAttribute("modify", todo);
		request.getRequestDispatcher("/WEB-INF/views/updateTodo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		Todo modify = new Todo();
		modify.setContent(request.getParameter("content"));
		modify.setTargetDate(Date.valueOf(request.getParameter("date")));
		modify.setDone(Boolean.parseBoolean(request.getParameter("done")));
		modify.setCategory(Integer.parseInt(request.getParameter("category")));
		modify.setCtgName(service.ctgName(Integer.parseInt(request.getParameter("category"))));
		modify.setIdx(idx);
		
		if(service.todoupdate(modify)) {
			request.setAttribute("modifyTodo", modify);
			request.getRequestDispatcher("/WEB-INF/views/updateTodo2.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "수정 실패");
			request.getRequestDispatcher("/WEB-INF/views/updateTodo.jsp").forward(request, response);
		}
	}

}
