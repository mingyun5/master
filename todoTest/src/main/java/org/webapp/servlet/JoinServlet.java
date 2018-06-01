package org.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.webapp.dao.User;
import org.webapp.dao.UserService;


@WebServlet("/joinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= new User();
		
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		
		if(service.saveUser(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user.getId());
			request.setAttribute("name", user.getName());
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}
		
	}

}
