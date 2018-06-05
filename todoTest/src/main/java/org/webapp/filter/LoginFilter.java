package org.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	FilterConfig config;
	String[] excludedUrl;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hrq = (HttpServletRequest) request;
		StringBuffer path = new StringBuffer(hrq.getRequestURI());

		if (hrq.getQueryString() != null) {
			path.append("?").append(hrq.getQueryString());
		}

		for (String s : excludedUrl) {
			if (path.toString().equals(s) || path.toString().contains("/resources")) {
				chain.doFilter(request, response);
				return;
			}
		}

		HttpSession session = hrq.getSession();
		String id = (String) session.getAttribute("user_id");

		if (id != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("error", "먼저 로그인을 하세요");
			request.setAttribute("orgPath", path.toString());
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		String url = config.getInitParameter("excluded");
		excludedUrl = url.split(",");

		for (int i = 0; i < excludedUrl.length; i++) {
			excludedUrl[i] = excludedUrl[i].trim();
		}

	}

}
