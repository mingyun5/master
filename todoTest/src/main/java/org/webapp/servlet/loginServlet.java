package org.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.webapp.dao.UserService;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService service = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
				
		if(service.isValidUser(id, pw)) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
			request.setAttribute("name", service.getName(id));
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			request.setAttribute("ok", "로그인 성공");
		}else {
			request.setAttribute("error", "로그인에 실패하셨습니다");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

}
